package com.study.mvc.service;

import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.entity.Study;
import com.study.mvc.repository.DBStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBStudyService {
    @Autowired
    private DBStudyRepository dbStudyRepository;

    public int createStudy(DBStudyReqDto dbStudyReqDto) { // contoller에서 받아온 dto를 service로 매개변수로 넘겨줌, int로 받은 이유: 응답 성공횟수
        // dto를 엔티티로 바꾸는 메소드
        // repository 안의 save 함수 호출

        // AllArgs
//        Study study = new Study(0, dbStudyReqDto.getName(), dbStudyReqDto.getAge(), null);

        // NoArgs
        // 빈객체 생성후 setter로 가져오기
//        Study study = new Study();
//        study.setName(dbStudyReqDto.getName());
//        study.setAge(dbStudyReqDto.getAge());


        // Builder
        Study study = Study.builder()
                .name(dbStudyReqDto.getName())
                .age(dbStudyReqDto.getAge())
                .build();

        return dbStudyRepository.save(study); // study안에 dto를 엔티티로 변환후 넣어줌, study를 repository로 넘겨줌
    }
}
