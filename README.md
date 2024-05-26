# eduService_backend_dev
  - Spring Data Jpa 기반 에듀 서비스 개발 리포지토리
  - 협업 관리 시스템 백엔드 RestAPI 개발(교육 플랫폼용으로 기획했으나, 타 사업군으로 확장 가능성을 열어놓고 서비스 기획 및 개발)

## 기능 목록
  - 회원 기능
    - 회원 등록
    - 회원 조회
    - 회원 수정
    - 회원 삭제
  - 업무 기능
    - 업무 등록
    - 업무 조회
    - 업무 수정
    - 업무 삭제
  - 하위업무 기능
    - 하위업무 등록
    - 하위업무 조회
    - 하위업무 수정
    - 하위업무 삭제
      
  - 기타 요구사항
    - 일반
      - Task 생성 시, 한 개 이상의 팀을 설정해야 한다. -> Task와 생성팀은 1:1 매칭으로 OneToOne 관계이다.
      - Task를 생성하는 팀이 반드시 SubTask를 맡아 진행하지는 않아도 된다. 포함될 수도 있고 아닐 수도 있다.
      - 존재하는 7개 팀 이외 다른 팀에는 SubTask를 부여할 수 없다.
      - 회원가입을 할 떄, 팀을 선택해서 어느 팀에 속할지를 결정하고 속한 팀의 정보를 갖고 있는다.
    - Task 조회 시,
      - 업무 조회 시 하위업무에 본인 팀이 포함되어 있다면 업무 목록에서 확인이 가능해야 한다.(본인 팀이라는 것은, 로그인 되어 있는 것을 기준으로 로그인된 유저의 팀으로 가정한다.)
        - Task 조회 시, SubTask 필드는 반드시 포함되어야 한다.
      - 업무 조회 시 하위업무의 완료 여부를 확인할 수 있어야 한다.
      - 업무는 작성자 이외에는 수정이 불가하다.
      - 업무에 할당된 하위업무를 맡은 팀 목록은 수정, 삭제가 가능해야 한다. 단, 하위업무가 완료처리 되었다면 수정, 삭제 되어서는 안된다.
      - 업무 아래 모든 하위업무가 완료처리가 되면 상위 업무는 자동으로 완료 처리가 되어야 한다.
      - 하위업무의 완료 처리는 소속된 팀만 처리 가능하다.
    - Task 수정 시,
      - 완료되지 않은 SubTask에 한해서, SubTask를 맡은 팀들의 수정이 가능해야 한다.
      - 만약 완료된 SubTask가 있다면 요청은 무시되어야 하고 수정되어선 안된다.






   


