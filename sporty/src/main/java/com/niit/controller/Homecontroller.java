package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.dao.UserDao;
import com.niit.model.CartModel;
import com.niit.model.CategoryModel;
import com.niit.model.ProductModel;
import com.niit.model.SupplierModel;
import com.niit.model.UserModel;

@Controller

public class Homecontroller {
	@Autowired
	CategoryDao categoriesDao;

	@Autowired
	SupplierDao suppliersDao;

	@Autowired
	ProductDao productDao;
	@Autowired
	UserDao userDao;
	@Autowired
     CartDao cartDao;

	@RequestMapping("/")
	ModelAndView goHome() {
		ModelAndView model = new ModelAndView("index");
		model.addObject("catlist", categoriesDao.getCategories());
		return model;
	}
	@RequestMapping("/notaccessible")
	public String notaccess() {
		return "noAccessPage";
	}
	
	
	
	@RequestMapping("/userLogged")
	public String userLogged()
	{
	return "redirect:/";
}
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping("/register")
	String goregister() {
		return "register";
	}
	@RequestMapping("/productedit")
	String goproductedit() {
		return "productedit";
	}

	@RequestMapping("/categories")
	ModelAndView gocategories() {
		ModelAndView mv = new ModelAndView("categories");
		mv.addObject("categorylist", categoriesDao.getCategories());
		mv.addObject("supplierlist", suppliersDao.getSupplier());
		return mv;

	}
	@RequestMapping(value = "/userproductlist/{pId}", method = RequestMethod.GET)
	public ModelAndView gouserproductlist(@PathVariable("pId") int pid) {
		ModelAndView mv = new ModelAndView("userproductlist");
		mv.addObject("product", productDao.getProductDetail(pid));
		return mv;
	}


	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("catlist", categoriesDao.getCategories());
	}

	@RequestMapping("/addCategory")
	ModelAndView addCategoryClick(@RequestParam("cid") int id, @RequestParam("cname") String name) {
		CategoryModel category = new CategoryModel();
		category.setCategoryId(id);
		category.setCategoryName(name);
		categoriesDao.savecategory(category);
		return new ModelAndView("categories");
	}

	@RequestMapping("/addSupplier")
	ModelAndView addSupplierClick(@RequestParam("sid") int id, @RequestParam("sname") String name) {
		SupplierModel supplier = new SupplierModel();
		supplier.setSupplierId(id);
		supplier.setSupplierName(name);
		suppliersDao.savesupplier(supplier);
		return new ModelAndView("categories");
	}

	@RequestMapping("/addProduct")
	ModelAndView addProductClick(@RequestParam("pid") int id, @RequestParam("pname") String name,
			@RequestParam("pdescription") String description, @RequestParam("pprice") double price,
			@RequestParam("pquantity") int quantity, @RequestParam("file") MultipartFile file,
			@RequestParam("categoryitems") int cid, @RequestParam("supplieritems") int sid,
			HttpServletRequest request) {
		ProductModel Productmodel = new ProductModel();
		Productmodel.setName(name);
		Productmodel.setId(id);
		Productmodel.setDescription(description);
		Productmodel.setPrice(price);
		Productmodel.setQuantity(quantity);
		// Productmodel.setImage(image);
		CategoryModel cat = categoriesDao.getcategorybyid(cid);
		Productmodel.setProdCategory(cat);
		SupplierModel sup = suppliersDao.getsupplierbyid(sid);
		Productmodel.setProdSupplier(sup);
		String filename = id + file.getOriginalFilename();
		Productmodel.setpImage(filename);
		productDao.saveProductmodel(Productmodel);

		String path = request.getSession().getServletContext().getRealPath("/resources/");

		System.out.println(path + "" + filename);

		byte barr[];
		try {
			barr = file.getBytes();
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + filename));
			bout.write(barr);
			bout.flush();
			bout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("categories");
	}

	@RequestMapping("/categorylist")
	ModelAndView gocategorylist() {
		List<CategoryModel> categorylist = categoriesDao.getCategories();
		ModelAndView mv = new ModelAndView();
		mv.addObject("catlist", categorylist);
		mv.setViewName("categorylist");
		return mv;
	}

	@RequestMapping("/supplierlist")
	ModelAndView gosupplierlist() {
		List<SupplierModel> supplierlist = suppliersDao.getSupplier();
		System.out.println("Supplier List " + supplierlist.size());
		ModelAndView mv = new ModelAndView();
		mv.addObject("suplist", supplierlist);
		mv.setViewName("supplierlist");
		return mv;
	}

	@RequestMapping("/productlist")
	ModelAndView goproductlist(@RequestParam("cid") int cid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("prolist", productDao.getproductsbycategoryid(cid));
		mv.setViewName("productlist");
		return mv;
	}

	@RequestMapping("/productview")
	ModelAndView goproductview() {

		ModelAndView mv = new ModelAndView();
		mv.addObject("prolist", productDao.getproducts());
		mv.setViewName("productview");
		return mv;

	}
	/*@RequestMapping(value = "/productedit/{prodId}", method = RequestMethod.GET)
	
	public String editProduct(@PathVariable("prodId") int pid) {
		System.out.println("Product id" + pid);
		productDao.delete(productDao.getProductDetail(pid));


		return "redirect:/productedit";
	}

*/

	@RequestMapping(value = "/productDelete/{prodId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable("prodId") int pid) {
		System.out.println("Product id" + pid);
		productDao.delete(productDao.getProductDetail(pid));

		return "redirect:/productview";
	}
	@RequestMapping("/addUser")
	ModelAndView addUserClick(@RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("mail") String u_mail, @RequestParam("passwd") String u_password,
			@RequestParam("phone") String phone, @RequestParam("address") String address) {

		UserModel usermodel = new UserModel();
		usermodel.setU_name(name);
		usermodel.setAge(age);
		usermodel.setU_mail(u_mail);
		usermodel.setU_password(u_password);
		usermodel.setPhone((phone));
		usermodel.setAddress(address);
		usermodel.setEnabled(true);
		usermodel.setRole("ROLE_USER");
		userDao.addUser(usermodel);
		return new ModelAndView("index");

	}


	@RequestMapping(value="/addCart",method = RequestMethod.POST)
	public ModelAndView goAddCart(HttpServletRequest request)
	{
		CartModel cartmodel = new CartModel();
		System.out.println("Cart Details...........");
		ModelAndView mv=new ModelAndView();
		try
		{
		
		int pid=Integer.parseInt(request.getParameter("cartpid"));
		System.out.println("Cart Details..........."+Double.parseDouble(request.getParameter("cartprice")));
		double price=Double.parseDouble(request.getParameter("cartprice"));
		int qty=Integer.parseInt(request.getParameter("prodquantity"));
		String cartImage=request.getParameter("cartImage");
		String cartProdName=request.getParameter("cartProdName");
		cartmodel.setCartImage(cartImage);
		cartmodel.setPname(cartProdName);
		cartmodel.setProductId(pid);
		cartmodel.setQuantity(qty);
		cartmodel.setPrice(price);
		
		
		
		cartDao.addToCart(cartmodel);
		
		
		Principal  principal=request.getUserPrincipal();
		String userId=principal.getName();
		CartModel exist=cartDao.getCartItem(pid, userId);
		
		if(exist==null)
		{
		CartModel cm=new CartModel();
		cm.setPrice(price);
		cm.setCartItemId(pid);
		cm.setQuantity(qty);
		cm.setCartImage(cartImage);
		cm.setPname(cartProdName);
		UserModel c = userDao.getUserDetail(userId);
		cm.getCartUserDetails();
		
		cartDao.addToCart(cm);
		}
		else
		{
			CartModel cm=new CartModel();
			cm.setCartItemId(exist.getCartItemId());
			cm.setPrice(price);
			cm.setCartItemId(pid);
			cm.setQuantity(exist.getQuantity()+qty);
			cm.setCartImage(cartImage);
			cm.setPname(cartProdName);
			UserModel c = userDao.getUserDetail(userId);
			cm.setCartUserDetails(c);
			cartDao.updateCart(cm);
		}
		
		//mv.addObject("cartDetails",cartDao.getCartById(userId));
		mv.setViewName("viewcart");
		return mv;
		}
		catch(NullPointerException ex)
		{
			mv.setViewName("userproductlist");
			return mv;
		}
		}

	
	
	

@RequestMapping("/viewcart")
public ModelAndView goviewcart(){
	List<CartModel> cartList=cartDao.getAll();
	ModelAndView mv=new ModelAndView();
	mv.addObject("cartlist", cartList);
	mv.setViewName("cartList");
	return mv;
}

@RequestMapping("/cart_delete")
public ModelAndView editCart(HttpServletRequest request)
{
	int cid=Integer.valueOf(request.getParameter("id"));
	CartModel c=cartDao.getId(cid);
	cartDao.deleteCart(c);
	
	ModelAndView mv=new ModelAndView("viewcart");
	List<CartModel> cartList=cartDao.getAll();
	
	mv.addObject("cartlist", cartList);
	return mv;
}

@RequestMapping("/customerDetails")
public ModelAndView customer(HttpServletRequest request)
{
	int tot=Integer.valueOf(request.getParameter("tot"));
	System.out.println(tot);
	ModelAndView mv=new ModelAndView("checkout");
	mv.addObject("tot", tot);
	return mv;
}

@RequestMapping("/invoice")
public ModelAndView invoice(HttpServletRequest request)
{
	String name=request.getParameter("name");
	String add=request.getParameter("add");
	String phone=request.getParameter("contact_no");
	String email=request.getParameter("email");
	String tot=request.getParameter("tot");
	UserModel usermodel=new UserModel();
	usermodel.setU_name(name);
	usermodel.setAddress(add);
	usermodel.setPhone(phone);
	usermodel.setU_mail(email);
	userDao.persist(usermodel);
	
	ModelAndView mv=new ModelAndView("invoice");
	mv.addObject("name", name);
	mv.addObject("add", add);
	mv.addObject("phone", phone);
	mv.addObject("email", email);
	mv.addObject("tot", tot);
	

	return mv;
}

@RequestMapping("/Confirm")
public String confirm()
{
	return "Confirm";
}
}
