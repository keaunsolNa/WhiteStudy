# TCB(Thread Control Block)

![Untitled](TCB(Thread_Control_Block)/Untitled.png)

# Definition

- TCB ⇒ Thread를 Control 하는 구조체(자료 구조)
- 해당 스레드에 대한 정보만 저장한다.
- TCB는 PCB와 매우 유사한 구조로 시스템에서 생성된 thread를 나타낸다.
- ID 및 상태와 같은 thread에 대한 정보가 포함된다.
- thread 라이브러리에 의해 문맥 교환 되는 thread 정보의 단위다.
- PCB 내 TCB를 수용하는 것으로 kernel은 thread를 실현 시킨다.
- Thread가 하나 생성될 때마다 PCB 내에서 TCB가 확장된다.
- 아래의 예시에서는 한 프로세스 내에서 2개의 스레드가 추가 생성되어 총 3개의 스레드가 독립적으로 실행되는 중이다.
    
    ![https://blog.kakaocdn.net/dn/pouij/btrHaUySUkZ/22UlS0GsFh6QBaRKgcGUTk/img.png](https://blog.kakaocdn.net/dn/pouij/btrHaUySUkZ/22UlS0GsFh6QBaRKgcGUTk/img.png)
    

# TCB의 특징

- 커널 레벨에서 문맥 교환의 기본 단위가 된다.
- 같은 프로세스에서의 문맥 교환에 대해서는 TCB정보만 저장하면 된다.
- 하지만 다른 프로세스 간에 문맥 교환을 할 때에는 PCB/TCB 정보를 모두 저장해야 한다.
- 데이터 섹션이나 프로세스-커널 정보(File descriptor와 같은 프로세스 의존정보)를 포함해야 하는 PCB에 비해 스레드를 식별하기 위해 필요한 정보들(스택 포인터, 레지스터 정보 등)만을 저장하기 때문에 가볍고 빠르다.
    
    → 따라서, 프로세스의 스케쥴링보다는 TCB를 이용하는 스레드 스케쥴링이 훨씬 빠르다.
    

# TCB의 역할

- TCB의 신규 등록(Thread 생성)은 생각보다 많은 Resource가 필요하다.
- 개별 프로세스에서 수행하는 각각의 명령마다 하나의 Thread를 만드는 것은 자원의 낭비로 이어진다.
- 그렇기에 보통 현대 OS는(특히 게임서버처럼 부하가 큰 서버는) 미리 Thread를 생성하고 제어하는 방식을 취한다.
- 평상시에는 생성되어 있는 Thread를 Waiting(Sleep) 상태로 두고 있다가 부하가 있을 때 Waiting 상태의 Thread를 active 시킨다.
- TCB는 위의 프로세스들을 관리하는 역할을 한다.

# TCB의 구조

![Untitled](TCB(Thread_Control_Block)/Untitled1.png)

- **Thread ID** : 스레드가 생성될 때 운영 체제에서 스레드에 할당하는 고유 식별자를 말한다.
- **Thread State** : 스레드가 시스템을 통해 진행됨에 따라 변경되는 스레드의 상태를 말한다.
- **CPU Information** : 스레드가 얼마나 진행되었는지, 어떤 데이터가 사용되고 있는지 등 OS가 알아야 하는 모든 정보가 포함된다.
- **Thread Priority** : 스레드 스케줄러가 READY 큐에서 다음에 선택해야 하는 스레드를 결정하는 데 도움이 되는 다른 스레드에 대한 스레드의 가중치(우선순위)를 나타낸다.
- **Pointer to process that create this thread** : 이 스레드 생성을 트리거한 프로세스를 가리키는 포인터
- **Pointer to other threads that were created by this thread** : 이 스레드에 의해 생성된 스레드를 가리키는 포인터이다.
- S**tack pointer** ( stack : 스레드가 함수 호출할때 저장하는 곳)
    - 메모리영역 중 PCB는 커널 영역TCB는 유저영역과 커널 영역에 둘다 있을 수 있다.

# 3. 요약

- PCB는 OS의 스케줄러에 의해 Context Switching되는 프로세스의 정보 단위를 의미하고 TCB는 스레드 라이브러리에 의해 Context Switching되는 스레드의 정보 단위를 의미한다.

[https://lh4.googleusercontent.com/Ov67zFw-Y5UXrxaz8ZqdPTrzxe0bSpQGXS-Nbz90qXRikQJV3P6dwClAaL1CZO3sxk65X3h22t82phtCo2GdjIe98KG98AZ75e1Ana6hJmAqRYbNIZfjffOidi0jxBOkjWsRQa07](https://lh4.googleusercontent.com/Ov67zFw-Y5UXrxaz8ZqdPTrzxe0bSpQGXS-Nbz90qXRikQJV3P6dwClAaL1CZO3sxk65X3h22t82phtCo2GdjIe98KG98AZ75e1Ana6hJmAqRYbNIZfjffOidi0jxBOkjWsRQa07)

- 즉, 우리가 흔히 배우는 OS의 스케줄러가 스케줄링 해주는 것은 프로세스의 PCB이고, TCB는 프로세스에 있는 스레드 라이브러리에 의해 스케줄링 되는 것이다.
- 그래서 컨텍스트 스위칭이 일어날 때 멀티 프로세스를 통해 PCB를 컨텍스트 스위칭 하는 것 보다 멀티 스레드를 통해 TCB를 컨텍스트 스위칭 하는 것이 더 오버헤드가 적다.(위의 그림만 봐도 TCB가 PCB보다 작은 크기를 가지고 있다.)