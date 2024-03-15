package org.example.controller;

import org.example.dto.CoachModelDTO;
import org.example.models.services.CoachService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coach")

public class CoachController {
    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/getCoach")
    public ResponseEntity<CoachModelDTO> getCoachController(@RequestParam String name) {
        return ResponseEntity.ok(coachService.getCoach(name));
    }

    @PostMapping("/addCoach")
    public ResponseEntity<CoachModelDTO> addNewCoachController(@RequestBody CoachModelDTO coachModelDTO) {

        return ResponseEntity.ok(coachService.addNewCoach(coachModelDTO));
    }

    @PutMapping("/updateCoach")
    public ResponseEntity<CoachModelDTO> updateCoachController(@PathVariable int id, @RequestBody CoachModelDTO coachModelDTO) {

        return ResponseEntity.ok(coachService.updateCoach(coachModelDTO, id));
    }

    @DeleteMapping("/deleteCoach/{firstName}")
    public ResponseEntity<?> deleteCoachController(@PathVariable int id) {

        coachService.deleteCoach(id);
        return ResponseEntity.ok("DeleteOK");
    }
}
