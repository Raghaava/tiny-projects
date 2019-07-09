package org.learning.filedownload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@SpringBootApplication
public class Application {
  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }
}

@RestController
class FileController {
  @GetMapping(value = "/file")
  public ResponseEntity<Resource> getFile() throws MalformedURLException {
    Resource resource = new FileUrlResource("input.txt");
    return ResponseEntity.ok()
       // .contentType(MediaType.parseMediaType("application/octet-stream"))
     //   .header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=input.txt")
        .body(resource);
  }
}
