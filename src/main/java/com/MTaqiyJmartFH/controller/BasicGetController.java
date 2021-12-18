package com.MTaqiyJmartFH.controller;

import java.util.List;

import com.MTaqiyJmartFH.Algorithm;
import com.MTaqiyJmartFH.dbjson.JsonTable;
import com.MTaqiyJmartFH.dbjson.Serializable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Kelas acuan untuk akses database
 * 
 * @author mtaqi
 * @version 1.0
 * @since 17 Desember 2021
 *
 */
@RestController
public interface BasicGetController<T extends Serializable> {
    @GetMapping("/{id}")
    public default T getById(@PathVariable int id) {
        return Algorithm.<T>find(getJsonTable(), e -> e.id == id);
    }

    public abstract JsonTable<T> getJsonTable();
    
    /**
     * method controller untuk menampilkan data dalam page
     * 
     * @param page			nomor urut page
     * @param pageSize		ukuran halaman
     * @return				tampilan halaman melalui method paginate pada kelas algorithm
     */
    @GetMapping("/page")
    public default List<T> getPage(int page, int pageSize) {
        final JsonTable<T> table = getJsonTable();
        return Algorithm.paginate(table, page, pageSize, o -> true);
    }

}