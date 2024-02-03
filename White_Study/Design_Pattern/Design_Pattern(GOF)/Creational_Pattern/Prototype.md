# Prototype

![Untitled](Prototype/Untitled.png)

# 정의

- 어떤 class의 인스턴스를 만드는 것이 자원/시간을 많이 소요하거나 복잡한 경우 사용된다.
- 기존 인스턴스를 복사하여 새로운 인스턴스를 만들 수 있다.
    - ⇒ Original 객체를 새로운 객체에 복사(clone())하여 필요에 따라 수정하는 메커니즘을 제공한다.
- 기본적인 개념은 처음부터 새 인스턴스를 만드는 대신 기존 객체를 복사하는 것이다.
    - 기존 객체는 프로토타입 역할을 하며 객체의 상태를 포함한다.
- 클라이언트 코드에서 어떤 클래스의 인스턴스를 만드는지 전혀 모르는 상태에서도 새로운 인스턴스를 만들 수 있다.
- 패턴을 구현하기 위해 클라이언트는 순수 가상 clone() method를 지정하는 추상 기본 클래스를 선언한다.
- 클라이언트는 하드 코딩 된 class 이름에 대해 “new” 연산자를 호출하는 코드를 작성하는 대신 Prototype에서 clone() method를 호출하거나, 원하는 특정 구체적 파생 Class를 지정하는 매개 변수가 있는 Factory method를 호출하거나, 다른 Design Pattern에서 제공하는 일부 메커니즘을 통한 clone() method를 호출할 수 있다.

# 장점과 단점

- 장점
    - 런타임 시 제품 추가 및 제거
        - Prototype을 사용하면 클라이언트에 Prototype 인스턴스를 등록하기만 하면 새로운 구체적인 제품 class를 시스템에 통합할 수 있다.
        - 클라이언트가 런타임에 Prototype을 설치하고 제거할 수 있기에 다른 생성 패턴보다 약간 더 유연하다
    - 값을 변경하여 새 객체 지정
        - 매우 동적인 시스템을 사용하면 새 클래스를 정의하는 것이 아니라 객체 변수의 값을 지정하여 객체 구성을 통해 새로운 동작을 정의할 수 있다.
    - 다양한 구조로 새 객체 지정
        - 많은 응용 프로그램은 부분과 하위 부분에서 객체를 만든다.
        - 편의를 위해 응용 프로그램에서는 복잡한 사용자 정의 구조를 인스턴스화 하여 특정 하위 회로를 반복해서 사용할 수 있는 경우가 많다.
    - 클라이언트로부터 구체적인 제품 클래스를 숨긴다.
        - 클라이언트는 새로운 인스턴스를 만드는 과정을 몰라도 되며, 구체적인 형식을 알지 못 해도 객체를 생성할 수 있다.
- 단점
    - 매우 적은 수의 객체를 사용하거나 Prototype 체인 확장을 기본적으로 강조하지 않는 프로젝트의 경우 과잉이 될 수 있다
    - Prototype의 각 하위 클래스는 고려 중인 class가 이미 존재하는 경우 clone() 작업을 직접 구현해야 한다.
    - 또한 내부에 복사를 지원하지 않거나 순환 참조가 있는 객체가 있을 경우 clone()을 구현하는 것은 매우 어려울 수 있다.

# 구현

```java
// A Java program to demonstrate working of
// Prototype Design Pattern with example 
// of a ColorStore class to store existing objects.
 
import java.util.HashMap;
import java.util.Map;
 
// Cloneable interface allows the implementing class to 
// have its objects to be cloned instead of using a new operator. 
// It is available in Java.lang.Cloneable.
 
abstract class Color implements Cloneable
{
     
    protected String colorName;
      
    abstract void addColor();
      
    public Object clone()
    {
        Object clone = null;
        try
        {
            clone = super.clone();
        } 
        catch (CloneNotSupportedException e) 
        {
            e.printStackTrace();
        }
        return clone;
    }
}
 
class blueColor extends Color
{
    public blueColor() 
    {
        this.colorName = "blue";
    }
  
    @Override
    void addColor() 
    {
        System.out.println("Blue color added");
    }
     
}
 
class blackColor extends Color{
  
    public blackColor()
    {
        this.colorName = "black";
    }
  
    @Override
    void addColor() 
    {
        System.out.println("Black color added");
    }
}
  
class ColorStore {
  
    private static Map<String, Color> colorMap = new HashMap<String, Color>(); 
      
    static
    {
        colorMap.put("blue", new blueColor());
        colorMap.put("black", new blackColor());
    }
      
    public static Color getColor(String colorName)
    {
        return (Color) colorMap.get(colorName).clone();
    }
}
 
 
// Driver class
class Prototype
{
    public static void main (String[] args)
    {
        ColorStore.getColor("blue").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("black").addColor();
        ColorStore.getColor("blue").addColor();
    }
}
```