/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import apresentacao.RepeatPaginator;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author guto
 */
@Named(value = "paginatorBean")
@Dependent
public class PaginatorBean {
 private List<String> list;
    private RepeatPaginator paginator;

    @PostConstruct
    public void init() {
        this.list = new ArrayList<String>();
        this.list.add("Item 1");
        this.list.add("Item 2");
        this.list.add("Item 3");
        this.list.add("Item 4");
        this.list.add("Item 5");
        this.list.add("Item 6");
        this.list.add("Item 7");
        this.list.add("Item 8");
        this.list.add("Item 9");
        this.list.add("Item 10");
        this.list.add("Item 11");
        paginator = new RepeatPaginator(this.list);
    }

    public RepeatPaginator getPaginator() {
        return paginator;
    }
}
