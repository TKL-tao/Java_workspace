# Spring-boot Learning
## Spring MVC HTTP
```{r echo=FALSE, warning=FALSE}
mydf <- data.frame(
  column1 = c("注解", "经典用途"),
  column2 = c('@GetMapping', '读取资源数据'),
  column3 = c('@PostMapping', '创建资源'),
  column4 = c('@PutMapping', '更新资源'),
  column5 = c('@PatchMapping', '更新资源'),
  column6 = c('@DeleteMapping', '删除资源'),
  column7 = c('@RequestMapping', '通用请求处理')
)
kable(t(mydf), "html", booktabs = T, col.names = NULL, row.names=F, align = "c") %>%
  kable_styling(bootstrap_options = 'bordered', latex_options = "striped", full_width = F)
```

## Spring RESTful

```java
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;

import tacos.Taco;
import tacos.data.TacoRepository;

@RestController
@RequestMapping(path = "/api/tacos", produces = "application/json")
@CrossOrigin(origins = {"http://tacocloud:8080", "http://tacocloud.com"})
public class TacoController {
    private TacoRepository tacoRepository;

    public TacoController(TacoRepository tacoRepository) {
        this.tacoRepository = tacoRepository;
    }

    @GetMapping(params  = "recent")
    public Iterable<Taco> recentTacos() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        return tacoRepository.findAll(page).getContent();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        try {
            tacoRepository.deleteById(orderId);
        } catch (EmptyResultDataAccessException e) {}
    }
}
```
#### public Iterable<Taco> recentTacos()部分

**从服务器端检索数据**。

当我使用`curl localhost:8080/api/tacos?recent`时，会得到返回的json格式内容。

#### public Taco postTaco(@RequestBody Taco taco)部分

**发送数据到服务器端**。

`postTaco()`方法会处理对`/api/tacos`的POST请求。`consumes = "application/json"`意味着请求的输入需要为json格式文件。

`@RequestBody Taco taco`请求体中的json被绑定到参数*taco*上。