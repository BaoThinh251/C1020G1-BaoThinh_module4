package ajax.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ajax.ajax.model.Blog;
import ajax.ajax.service.RestFulService;

import java.util.List;

@CrossOrigin
@RestController
public class RestFulController {

    @Autowired
    RestFulService restFulService;

//    @RequestMapping(value = "/blog/", method = RequestMethod.GET)
//    public ResponseEntity<List<Blog>> listAllBlog() {
//        List<Blog> blog = restFulService.findAll();
//        if (blog.isEmpty()) {
//            return new ResponseEntity<List<Blog>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Blog>>(blog, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Blog> getBlog(@PathVariable("id") int id) {
//        System.out.println("Blog id " + id);
//        Blog blog = restFulService.findById(id);
//        if (blog == null) {
//            System.out.println("Blog id " + id + " not found");
//            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Blog>(blog, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/blog/", method = RequestMethod.POST)
//    public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating blog " + blog.getName());
//        restFulService.save(blog);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/blog/{id}").buildAndExpand(blog.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }
//
//    @RequestMapping(value = "/blog/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Blog> deleteBlog(@PathVariable("id") int id) {
//        System.out.println("Fetching & Deleting Blog with id " + id);
//
//        Blog blog = restFulService.findById(id);
//        if (blog == null) {
//            System.out.println("Unable to delete. Blog with id " + id + " not found");
//            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
//        }
//
//        restFulService.remove(id);
//        return new ResponseEntity<Blog>(HttpStatus.NO_CONTENT);
//    }

    @GetMapping("/blog-list")
    public ResponseEntity<Page<Blog>> getAllPage(@PageableDefault(size = 3) Pageable pageable){
        Page<Blog> page = restFulService.findAllPage(pageable);
        if (page.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Blog>> search(@PageableDefault(size = 5) Pageable pageable, @RequestParam String search){
        Page<Blog> blogs = restFulService.findAllByName(search, pageable);
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

}
