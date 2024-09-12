package alpb.infra;

import alpb.domain.*;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/diaries")
@Transactional
public class DiaryController {

    @Autowired
    DiaryRepository diaryRepository;

    @RequestMapping(
        value = "/diaries/{id}//deletecartoon",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Diary deleteDiary(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /diary/deleteDiary  called #####");
        Optional<Diary> optionalDiary = diaryRepository.findById(id);

        optionalDiary.orElseThrow(() -> new Exception("No Entity Found"));
        Diary diary = optionalDiary.get();
        diary.deleteDiary();

        diaryRepository.save(diary);
        return diary;
    }
}
//>>> Clean Arch / Inbound Adaptor
