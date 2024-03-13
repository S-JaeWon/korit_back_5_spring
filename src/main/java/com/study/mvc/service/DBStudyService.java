package com.study.mvc.service;

import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.dto.DBStudyInsertRespDto;
import com.study.mvc.dto.DBStudySelectRespDto;
import com.study.mvc.entity.Study;
import com.study.mvc.exception.DuplicatedException;
import com.study.mvc.repository.DBStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DBStudyService {
    @Autowired
    private DBStudyRepository dbStudyRepository;

    public /*int*/DBStudyInsertRespDto createStudy(DBStudyReqDto dbStudyReqDto) { // contoller에서 받아온 dto를 service로 매개변수로 넘겨줌, int로 받은 이유: 응답 성공횟수
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

        Study findStudy = dbStudyRepository.findStudyByName(dbStudyReqDto.getName()); // 중복 체크
        if(findStudy != null) {
            return DBStudyInsertRespDto.builder()
                    .successStatus(false)
                    .build();
        }

        Study study = Study.builder()
                .name(dbStudyReqDto.getName())
                .age(dbStudyReqDto.getAge())
                .build();
//      -----------------------------------------------------------------------------------------
        int successCount = dbStudyRepository.save(study); // 실행되면 db insert, 1 가져옴

        DBStudyInsertRespDto dbStudyInsertRespDto = DBStudyInsertRespDto.builder()
                .id(study.getId()) // successCount 실행시 xml에서 id값 생성되어 study 안에 값넣어줌
                .name(study.getName())
                .age(study.getAge())
                .successStatus(successCount > 0) // 위에서 가져온 1을 사용
                .successCount(successCount)
                .build();
//        return dbStudyRepository.save(study); // study안에 dto를 엔티티로 변환후 넣어줌, study를 repository로 넘겨줌
        return dbStudyInsertRespDto;

    }
    public DBStudySelectRespDto findStudyById(int id) {
        Study study = dbStudyRepository.findStudyById(id);

        System.out.println(study);

        DBStudySelectRespDto dbStudySelectRespDto =
                DBStudySelectRespDto.builder()
                        .id(study.getId())
                        .name(study.getName())
                        .age(study.getAge())
                        .build();

        return dbStudySelectRespDto;
    }
    public DBStudySelectRespDto findStudyByName(String name) { // 리턴형 dto 이므로 오류 메세지 sout 사용 x
        Study study = dbStudyRepository.findStudyByName(name);

        System.out.println(study);

        return study == null ? null : study.toDto(); // entity study를 Dto로 변환하여 반환
    }

    public List<DBStudySelectRespDto> findAll() {
        List<DBStudySelectRespDto> respDtoList = new ArrayList<>();
        List<Study> studyList = dbStudyRepository.findAll();
        for(Study study : studyList) {
            respDtoList.add(study.toDto());
        }
        return respDtoList;
    }
    public List<DBStudySelectRespDto> findAll2() { // stream으로
        return dbStudyRepository.findAll()
                .stream()
                .map(Study::toDto)
                .collect(Collectors.toList());
    }

    public int deleteById(int id) {
        return dbStudyRepository.deleteById(id);
    }

    public int putById(int id, DBStudyReqDto dbStudyReqDto) {
        Study study = dbStudyReqDto.toEntity(id);
        return dbStudyRepository.putById(study);
    }
    public int patchById(int id, DBStudyReqDto dbStudyReqDto) {
        return dbStudyRepository.patchById(dbStudyReqDto.toEntity(id));
    }

    public void checkedDuplicatedByName(String name) {
        if(dbStudyRepository.findStudyByName(name) != null) {
            throw new DuplicatedException("이름 중복 오류");
        }
    }
}
