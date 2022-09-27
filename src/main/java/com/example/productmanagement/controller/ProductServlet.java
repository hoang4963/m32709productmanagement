package com.example.productmanagement.controller;

import com.example.productmanagement.models.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private final Service products = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action){
            case "create" -> showCreateForm(req,resp);
            case "edit" -> showEditForm(req,resp);
            case "delete" -> showdeleteForm(req,resp);
            case "detail" -> showDetail(req,resp);
            default ->  listProduct(req,resp);
        }
    }

    private void showDetail(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.products.findById(id);
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            req.setAttribute("product",product);
            dispatcher = req.getRequestDispatcher("product/detail.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void showdeleteForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.products.findById(id);
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            this.products.remove(id);
        }
        try {
            resp.sendRedirect("/products");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = this.products.findById(id);
        RequestDispatcher dispatcher;

        if (product == null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        }
        else {
            req.setAttribute("product", product);
            dispatcher = req.getRequestDispatcher("product/edit.jsp");
        }
        try{
            dispatcher.forward(req,resp);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action){
            case "create":
                createProduct(req,resp);
                break;
            case "edit":
                editProduct(req,resp);
                break;
        }
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Double cost = Double.parseDouble(req.getParameter("cost"));
        String description = req.getParameter("description");
        Product product = products.findById(id);
        RequestDispatcher dispatcher;
        if (product == null){
            dispatcher = req.getRequestDispatcher("error-404.jsp");
        }else {
            if (name != null){product.setName(name);}
            if (cost != null){product.setCost(cost);}
            if (description != null){product.setDescription(description);}
            this.products.update(id,product);
            req.setAttribute("product", product);
            req.setAttribute("message","Updated");
            dispatcher = req.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(req,resp);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Double cost = Double.parseDouble(req.getParameter("cost"));
        String description = req.getParameter("description");
        Product product = new Product(id,name,cost,description);
        this.products.save(product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/create.jsp");
        req.setAttribute("message","New product was created");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) {
        List<Product> productList = this.products.findAll();
        req.setAttribute("products", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
        try{
            dispatcher.forward(req,resp);
        }
        catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }
}
