package codespring.swLanguage.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import codespring.swLanguage.business.abstracts.programmingLanguageService;
import codespring.swLanguage.business.request.CreateSWLanguageRequest;
import codespring.swLanguage.business.request.DeleteSWLanguagesRequest;
import codespring.swLanguage.business.request.UpdateSWLanguagesRequest;
import codespring.swLanguage.business.response.GetAllSWLanguageResponse;
import codespring.swLanguage.business.response.GetIdSWLanguageResponse;
import io.swagger.v3.oas.annotations.*;

@RestController
@RequestMapping("/api/PLanguages")

public class programmingLanguageController {
    
    private programmingLanguageService pLanguageService;

   @Autowired
    public programmingLanguageController(programmingLanguageService pLanguageService) {
        this.pLanguageService = pLanguageService;
    }

    
    @Operation(summary = "{Kayıtlı Tüm Programlama Teknolojilerini Getirir}", tags = "Software Languages Services")
    @GetMapping("/getAll")
    public List<GetAllSWLanguageResponse> getAll() {
        return pLanguageService.getAll();
    }

    @GetMapping("/getId")
    @Operation(summary = "{Listeden Id ye Göre Kayıt Listeler}", tags = "Software Languages Services")
    public GetIdSWLanguageResponse getId( int id) throws Exception{
        return this.pLanguageService.getId(id);
    }

    
    @Operation(summary = "{Listeye Yeni Kayıt Ekler}", tags = "Software Languages Services")
    @PostMapping("/add")
    public void add(@RequestBody CreateSWLanguageRequest createSWLanguageRequest) throws Exception{
        this.pLanguageService.add(createSWLanguageRequest);
    }
     
    @PutMapping("/updateName")
    @Operation(summary = "{Listedeki Kaydı Günceller", tags = "Software Languages Services")
    public void update(@RequestBody UpdateSWLanguagesRequest updateSWLanguagesRequest) throws Exception {
        this.pLanguageService.update(updateSWLanguagesRequest);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "{Listeden Kayıt Siler}", tags = "Software Languages Services")
        public void delete(DeleteSWLanguagesRequest deleteSWLanguagesRequest){
            pLanguageService.delete(deleteSWLanguagesRequest);
}
}
