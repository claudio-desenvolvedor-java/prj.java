package org.senai.prj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

// http://localhost:8080/api/usuario/add?nome=claudio&email=claudio@gmail.com
@Controller
@RequestMapping(path="/api/usuario")


public class UsuarioController {

    @Autowired
    UsuarioRepository uRepository;
    
    @PostMapping ("/add")


    public @ResponseBody String addUsuario(
           @RequestParam String nome,
           @RequestParam String email  ) {
        Usuario obju = new Usuario();
        obju.setEmail(email);
        obju.setName(nome);
        uRepository.save(obju);
        return "salvo";        
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Usuario> buscarUsuarios(){
        return uRepository.findAll();
    }
    
}
