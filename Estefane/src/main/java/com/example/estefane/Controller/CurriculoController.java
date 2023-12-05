package com.example.estefane.Controller;

import com.example.estefane.Model.Curriculo;
import com.example.estefane.Repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {

    @Autowired
    private com.example.estefane.Repository.CurriculoRepository CurriculoRepository;

    @GetMapping
    public List<Curriculo> getAllCurriculos() {
        return CurriculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Curriculo getCurriculoById(@PathVariable Long id) {
        return CurriculoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Curriculo createCurriculo(@RequestBody Curriculo curriculo) {
        return CurriculoRepository.save(curriculo);
    }

    @PutMapping("/{id}")
    public Curriculo updateCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculo) {
        curriculo.setId(id);
        return CurriculoRepository.save(curriculo);
    }

    @DeleteMapping("/{id}")
    public void deleteCurriculo(@PathVariable Long id) {
        CurriculoRepository.deleteById(id);
    }
}
