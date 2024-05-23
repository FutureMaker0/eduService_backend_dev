package jpa.edu.service;

import jpa.edu.domain.SubTask;
import jpa.edu.repository.SubTaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SubTaskService {

    private final SubTaskRepository subTaskRepository;

    /**
     * SubTask 등록
     */
    @Transactional
    public Long createSubTask(SubTask subTask) {
        subTaskRepository.save(subTask);
        return subTask.getSubTaskId();
    }

    /**
     * SubTask 전체 조회
     */
    public List<SubTask> findAllSubTasks() {
        List<SubTask> allSubTasks = subTaskRepository.findAll();
        return allSubTasks;
    }


}
