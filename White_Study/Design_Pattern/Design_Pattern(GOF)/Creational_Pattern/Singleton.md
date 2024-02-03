# Singleton

![Untitled](Singleton/Untitled.png)

# 정의

- Singleton Pattern은 해당 class의 인스턴스가 하나만 만들어지고, 어디에서도 그 인스턴스에 접근할 수 있도록 하기 위한 패턴이다.
- 전역 변수는 사용하지 않으며 객체는 하나만 생성되도록 한다
- Singleton Pattern을 사용 시 전역 변수를 사용할 때와 마찬가지로 객체 인스턴스를 어디서든지 접근할 수 있도록 해 준다. 또한, 전역 변수를 사용할 때의 단점을 감수하지 않아도 된다.
    - 전역 변수에 객체를 대입 시 애플리케이션이 시작 될 때 객체가 생성(JVM 기준) 된다. 이 때 해당 객체가 자원을 많이 차지한다면 자원 낭비의 부담이 크다.
    - 단, Singleton Pattern을 사용 시 해당 객체를 사용할 때만 생성하므로, 자원 낭비의 부담이 적다.
- Singleton 패턴은 레지스트리 설정이 담겨 있는 객체, 연결 풀, 스레드 풀과 같은 자원 풀을 관리하는데 주로 사용된다.
- 싱글톤 객체가 필요할 때는 new 연산자를 통해 인스턴스를 직접 만드는 것이 아닌, 정적 메소드를 통해 인스턴스를 요청 해야 한다.
- 단, 고전적인 Singleton Pattern의 경우 Multi thread 환경에서 문제가 발생할 수 있다. (Race Condition을 발생시키는 경우)
    - getInstance()와 같은 정적 method를 통해 인스턴스 요청 시, 하나의 요청이 종료되기 전에 다른 요청이 추가된다면 singleton pattern은 하나의 인스턴스가 아닌 다른 인스턴스를 반환, 두 인스턴스가 동일한 인스턴스가 아니게 되기 때문이다.
- 이를 해결하기 위해서는 synchronized를 통한 동기화 처리가 필요하다. 동기화 처리 시 정적 method를 동시에 실행하여 서로 다른 객체를 생성하는 일을 없앨 수 있다.
    - 단, 속도의 문제가 생길 수는 있다.
- SIngleton은 자신의 인스턴스를 관리하는(그리고 전역 접근을 제공하는)것 외에도 원래 그 인스턴스를 사용하고자 하는 목적에 부합하는 작업을 책임져야 한다.
- Singleton은 기본적으로 개방-폐쇄 원칙을 위배한다. 높은 결합도로 인해 유지보수가 어려워지므로, singleton은 신중히 사용해야 한다.

# 구현

- 고전적 구현
    - Multi thread 환경에서 문제를 일으킬 수 있다.
        
        ```java
        // Classical Java implementation of singleton 
        // design pattern
        class Singleton
        {
            private static Singleton obj;
         
            // private constructor to force use of
            // getInstance() to create Singleton object
            private Singleton() {}
         
            public static Singleton getInstance()
            {
                if (obj==null)
                    obj = new Singleton();
                return obj;
            }
        }
        ```
        
- getInstance() 동기화 구현
    - 하나의 thread만 getInstance()를 실행한다. 단, 동기화 비용이 많이 들고 프로그램 성능이 저하될 수 있다.
    - getInstance()의 성능이 application에 중요하지 않은 경우 적합하다.
        
        ```java
        // Thread Synchronized Java implementation of 
        // singleton design pattern
        class Singleton
        {
            private static Singleton obj;
            private Singleton() {}
         
            // Only one thread can execute this at a time
            public static synchronized Singleton getInstance()
            {
                if (obj==null)
                    obj = new Singleton();
                return obj;
            }
        }
        ```
        
- 즉시 인스턴스화
    - 정적 초기화 프로그램에서 singleton 인스턴스를 만든다.
    - JVM은 class가 로드될 때 정적 초기화 프로그램을 실행하므로 thread 안정성이 보장된다.
    - 단, singleton class가 가볍고 프로그램 실행 전체에서 사용되는 경우에만 이 방법을 사용해야 한다.
        
        ```java
        // Static initializer based Java implementation of
        // singleton design pattern
        class Singleton
        {
            private static Singleton obj = new Singleton();
            private Singleton() {}
         
            public static Singleton getInstance()
            {
                return obj;
            }
        }
        ```
        
- (최적) 이중 확인 잠금 사용
    - obj가 null일 때 getInstance()에 대한 잠금을 한 번만 획득한다.
        
        ```java
        // Double Checked Locking based Java implementation of
        // singleton design pattern
        class Singleton
        {
            private static volatile Singleton obj  = null;
            private Singleton() {}
         
            public static Singleton getInstance()
            {
                if (obj == null)
                {
                    // To make thread safe
                    synchronized (Singleton.class)
                    {
                        // check again as multiple threads
                        // can reach above step
                        if (obj==null)
                            obj = new Singleton();
                    }
                }
                return obj;
            }
        }
        ```