package shrinker.resource;

import shrinker.domain.URL;
import shrinker.dto.NewUrlDTO;
import shrinker.dto.UrlDTO;
import shrinker.service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/url")
public class URLResource {

    @Autowired
    private URLService urlService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UrlDTO>> findAll() {
        List<URL> list = urlService.findAllFromUser();
        List<UrlDTO> listDTO = list.stream().map(UrlDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> insert(@Valid @RequestBody NewUrlDTO objDTO) {
        URL obj = urlService.fromDTO(objDTO);
        urlService.insert(obj);
        return ResponseEntity.ok(obj.getUrlEncurtada());
    }
}
