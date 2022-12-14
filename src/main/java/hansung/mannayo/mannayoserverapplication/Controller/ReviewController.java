package hansung.mannayo.mannayoserverapplication.Controller;

import hansung.mannayo.mannayoserverapplication.Model.Entity.Member;
import hansung.mannayo.mannayoserverapplication.Model.Entity.Review;
import hansung.mannayo.mannayoserverapplication.Service.ReviewService;
import hansung.mannayo.mannayoserverapplication.dto.MemberDto;
import hansung.mannayo.mannayoserverapplication.dto.ReviewDto;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService service;

    @GetMapping
    public ResponseEntity<List<Review>> findAll(){
        List<Review> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 때 받은 토큰",required = true,dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "id로 리뷰조회(1개)" ,notes = "Id로 리뷰를 조회한다")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Review> findbyId(@PathVariable Long id){
        Review obj = service.findbyId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Review> insert(@RequestBody ReviewDto reviewDto){
        return  ResponseEntity.ok(service.insert(reviewDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Review> update(@PathVariable Long id, @RequestBody ReviewDto obj){
        return ResponseEntity.ok().body(service.update(id,obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Review> delete(@PathVariable Long id, @RequestBody ReviewDto obj){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
