package com.marceloicampos.linguagens.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LinguagemController {

  @Autowired
  private LinguagemRepository repositorio;

  // private List<Linguagem> linguagens = List.of(
  // new Linguagem(
  // "Java",
  // "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_256x256.png",
  // 9),
  // new Linguagem(
  // "PHP",
  // "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_256x256.png",
  // 8),
  // new Linguagem(
  // "JavaScript",
  // "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/javascript/javascript_256x256.png",
  // 7));

  @GetMapping(value = "/")
  public String localhostLinguagens() {
    // return "Qual minha linguagem preferida ? <a href='http://localhost:8080/linguagem-preferida'>Descubra a minha Linguagem Preferida!</a>";
    // new url
    return "Qual minha linguagem preferida ? <a href='/linguagem-preferida'>Descubra a minha Linguagem Preferida!</a>";
  }

  @GetMapping(value = "/linguagem-preferida")
  public String processaLinguagemPreferida() {
    // return "Claro que é JAVA com Spring Boot !!! <a href='http://localhost:8080/linguagens'>Veja a API de linguagens</a>";
    // new url
    return "Claro que é JAVA com Spring Boot !!! <a href='/linguagens'>Veja a API de linguagens</a>";
  }

  @GetMapping("/linguagens")
  public List<Linguagem> obterLinguagens() {
    List<Linguagem> linguagens = repositorio.findAll();
    return linguagens;
  }

  @PostMapping("/linguagens")
  public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
    Linguagem linguagemSalva = repositorio.save(linguagem);
    return linguagemSalva;
  }

}
