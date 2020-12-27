### 프로젝트 소개
 본 프로젝트는 컴퓨터 키보드를 사용한 간단 피아노 & 드럼패드 프로젝트이며,  자바 이클립스 GUI를 통하여 피아노 한옥타브(**<키보드순>** 기본:A-K, #:W-U(R제외), 화음:Z-V ) 및 드럼 NUMPAD(1-9)에 맞추어 구현하였다. 1초의 피아노 소리 및 드럼 소리 WAV파일을 하나씩 다운로드하고, 이클립스의 clip을 사용하였다. 키보드 A-K,W-U(R제외) 그리고 Z-V key 중에서 해당 키 입력시 키값에 맞추어 소리를 내보내며 NUMPAD 1-9는 9가지(북,킥,스네어 등등)의 기본 드럼 한박자씩 소리를 내보낸다.
  
### 개요
 1. 키입력 소리 출력
 2. Record 기능 (키입력 피아노&드럼)
 3. WAV음악 파일 재생

### 사용된 프로그램 정보
   JDK1.8
   IDE: 이클립스

### 장점(잘한점)
  - 주로 버튼을 사용하여 버튼에 피아노 음을 넣고 클릭시 음을 출력하는데, 이 프로젝트는 컴퓨터 키보드를 사용하여 피아노 음을 한옥타브 안에서 다중으로 출력할 수 있으며 동시에 드럼 소리도 출력할 수 있다.
  - Record 기능이 있어 record를 누르면 TreeMap에 피아노와 드럼 키입력대로 시간 및 키가 저장되며 record한 소리를 다시 들을 수 있다.
  - 사용자 컴퓨터에 있는 WAV 음악 파일을 불러와 play, pause, stop 등 가능하며 play동시에 피아노와 드럼 소리를 출력할 수 있다.
  - 기능 구현을 위해 음악파일을 clip에 넣고 구현하는 방법을 공부했고, enum을 통한 상태 변화,  원하는 위치에 기능 버튼들을 고정하고 싶어 JFrame에 대해 더 공부하였다.  
  
  **설계** 
		 1. 피아노 흰건반과 검은 건반 위치 고정, 컴퓨터 키보드에 keylistener를 통해 입력값에 피아노 음을 넣었다.
   2. 드럼 패드 9개 위치 고정, NUMPAD 숫자 9개에 드럼 한박자 소리를 넣었다.
   3. WAV 음악파일 불러오기, 재생하기, 일시정지, 멈춤(0으로 돌리기), 리셋(등록된 WAV파일 지우기)를 구현하였다.
   4. 녹음, 정지, 녹음재생을 구현하였다.

### 힘들었던 점
  - 녹음기능에 많은 시간을 투자하였다. 처음에는 Audio 녹음을 사용하였는데 많은 어려움이 있었다. 처음 접해보는 기능들이여서 마이크녹음을 바이트 배열을 써서 입력 해야했으며 rate 및 채널 등등 입력해야하는 것이 많았다. 그럼에도 불구하고 녹음된 결과의 소리는 너무 별로였다. 그래서 Audio 녹음 음질 개선은 포기하고 TreeMap을 통해 키입력을 받아 저장한뒤 저장된 입력값의 소리를 다시 내보내는 것으로 해결하였다.
  - 피아노 버튼을 피아노처럼 흰검흰검 겹겹이 해서 구현을 하였지만 흰건반을 누를시 검은 건반 위로 올라와 덮어버렸다. 그래서 검은 건반을 위로 고정시키고 흰건반을 아래로 고정시켜 흰건반을 눌러도 튀어나오지 않게 할려고 하였으나 결국 찾지 못하였고 건반들의 사이즈를 줄여 겹치지 않게 해결 및 구현하였다.
 
### 부족한 점 및 개선해야 할 점
 -  WAV음악 파일은 하나 밖에 등록이 안되어 playlist를 추가적으로 개선해야 한다.
 -  피아노의 한옥타브만 사용하여 한정적인 음을 출력하는데 음을 더 추가 및 개선해야 한다.
 -  드럼 또한 다른 소리들을 추가 및 개선해야 한다.
 -  녹음된 것을 다시 내보낼 때 사용자가 입력한 만큼의 속도로 출력하지 않는다. 컴퓨터의 문제 또는 코드 입력값의 문제일 수 있지만 개선 할 수 있다면 개선 필요.
 -  녹음을 하고 다시 녹음을 했을 때, 덮어쓰기의 녹음이 된다. 이점을 개선해야 할 것 같다.

 <YoutubeLink>
<div>
  <a href="https://www.youtube.com/watch?v=sUIcFpxSJtI" target="_blank"><image src = "https://img.youtube.com/vi/sUIcFpxSJtI/mqdefault.jpg"></a>
</div>
  
  
  
[javadoc](https://imlee0216.github.io/megait_mini_project/MiniProject/doc/index.html)
