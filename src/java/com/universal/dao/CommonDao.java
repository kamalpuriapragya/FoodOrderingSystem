
package com.universal.dao;

import com.universal.db.DbConnection;
import com.universal.dto.FoodMenu;
import com.universal.dto.Order;
import com.universal.dto.User;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class CommonDao {

    
       public static boolean addUserRecord(User user){
       boolean flag=true;
        Connection conn=DbConnection.getConnection();
        System.out.println("connection"+conn);
        String sql="insert into userdata (firstname,lastname,contact,email,password,cpassword) values(?,?,?,?,?,?)";
   
     try{
        PreparedStatement ps=conn.prepareStatement(sql);
            
       
        ps.setString(1, user.getFirstname());
        ps.setString(2, user.getLastname());
        ps.setString(3,user.getContact() );
        ps.setString(4, user.getEmail());
        ps.setString(5,user.getPassword());
        ps.setString(6,user.getCpassword());
         if(user.getPassword().equals(user.getCpassword())){
        
     
        ps.execute();
             
         }
        else{
       System.out.print("password and confirm password must be same");
     }
         
     }
        catch(SQLException e){
         System.out.print(e);
        }
    return flag;
    
}

public static int loginUser(User user){
       boolean flag=true;
       
Connection conn=DbConnection.getConnection();
       String sql="select id,email,password  from userdata";
       int id=0;
       try{
       
       Statement st=conn.createStatement();
       ResultSet rs=st.executeQuery(sql);
       
       while(rs.next()){
            
            int dbId=rs.getInt("id");
            String dbemail=rs.getString("email");
            String dbpassword=rs.getString("password");
         
            
             String email=user.getEmail();
             String password=user.getPassword();
             if(email.equals(dbemail) && password.equals(dbpassword) )
           {
              System.out.print("Login Successfull");

              id=dbId;
             
       }else{
           System.out.println("login undone");}
       
       }

       }
     catch(Exception e)
     { out.print(e);
             }
    return id;
}
public static boolean addFoodRecord(FoodMenu foodmenu ){
       boolean flag=true;
        Connection conn=DbConnection.getConnection();
        System.out.println("connection"+conn);
        String sql="insert into foodmenu (food_name,category,price,quantity,description,image) values(?,?,?,?,?,?)";
   
     try{
        PreparedStatement ps=conn.prepareStatement(sql);
            
        ps.setString(1, foodmenu.getFood_name());
        ps.setString(2, foodmenu.getCategory());
        ps.setInt(3, foodmenu.getPrice());
        ps.setInt(4, foodmenu.getQuantity());
        ps.setString(5,foodmenu.getDescription());
        ps.setBlob(6,foodmenu.getImage());
        ps.execute();
              
   System.out.print("data added");
     
         }
       
      
        catch(SQLException e){
         System.out.print(e);
        }
    return flag;
    
}
   
    public static List<FoodMenu> displaymenu() throws IOException {
      
  FoodMenu foodMenu  = null;
    ArrayList<FoodMenu> food = new ArrayList<>();      
try{   
        Connection con = DbConnection.getConnection();
            System.out.println("connection"+con);
            String sql = "select * from foodmenu";   
              
               PreparedStatement ps = con.prepareStatement(sql);
               ResultSet rs = ps.executeQuery();
               
               while(rs.next()){
                   foodMenu=new FoodMenu();
               String foodname=rs.getString("food_name");
               String dbfoodcategory=rs.getString("category");
               int dbprice= rs.getInt("price");
               int dbquantity=rs.getInt("quantity");
               int dbfooditemid=rs.getInt("food_id");
               String dbdescription=  rs.getString("description");
               
                foodMenu.setFood_id(dbfooditemid);
                foodMenu.setFood_name(foodname);
                foodMenu.setCategory(dbfoodcategory);
                foodMenu.setPrice(dbprice);
                foodMenu.setQuantity(dbquantity);
                foodMenu.setDescription(dbdescription);
           
                                
food.add(foodMenu);
             }    
         }catch(Exception e){
            out.print(e);
           }     
return food; 
    }

    public static Blob getPhoto(int food_id) throws IOException{
    
     Blob blob = null;
                InputStream inputStream =null;
     Connection conn=DbConnection.getConnection();
        System.out.println("connection"+conn);
        String sql="select image from foodmenu where food_id="+food_id;
   
     try{
        PreparedStatement ps=conn.prepareStatement(sql);
         
            ResultSet result = ps.executeQuery();  
            
        while (result.next()) {
               
              blob = result.getBlob("image");
              System.out.println(blob);
                       
        }

         }
     
        catch(SQLException e){
         System.out.print(e);
        }
  
    
    return blob;
}
    
    public static List<FoodMenu> manageFoodMenu() throws IOException {
      
  FoodMenu foodMenu  = null;
    ArrayList<FoodMenu> foodlist = new ArrayList<>();      
try{   
        Connection con = DbConnection.getConnection();
            System.out.println("connection"+con);
            String sql = "select food_id,category,food_name,price from foodmenu";   
            PreparedStatement ps = con.prepareStatement(sql);
               ResultSet rs = ps.executeQuery();
               
               while(rs.next()){
                   foodMenu=new FoodMenu();
               String foodname=rs.getString("food_name");
               String dbfoodcategory=rs.getString("category");
               int dbfooditemid=rs.getInt("food_id");
               int dbprice=rs.getInt("price");
               
                foodMenu.setFood_id(dbfooditemid);
                foodMenu.setFood_name(foodname);
                foodMenu.setCategory(dbfoodcategory);
                foodMenu.setPrice(dbprice);
foodlist.add(foodMenu);
out.print("data retrived");
             }    
         }catch(Exception e){
            out.print(e);
           }     
return foodlist; 
    }

    public static boolean updateMenu(FoodMenu foodmenu) {
        boolean flag=true;
        Connection conn=DbConnection.getConnection();
        System.out.println("connection"+conn);
        int food_id=foodmenu.getFood_id();
        String foodname=foodmenu.getFood_name();
        String category=foodmenu.getCategory();
        int price=foodmenu.getPrice();
        int quantity  = foodmenu.getQuantity();
        String description= foodmenu.getDescription();
        InputStream image=foodmenu.getImage();
        String sql="update foodmenu set category=?,price=?,quantity=?,description=?,image=?,food_name=? where food_id="+food_id;
   
     try{
        PreparedStatement ps=conn.prepareStatement(sql);
          
        ps.setString(1,category );
        ps.setInt(2,price );
        ps.setInt(3, quantity);
        ps.setString(4,description);
        ps.setBlob(5,image);
        ps.setString(6,foodname);
        ps.execute();
               System.out.println("updated foodname is"+foodname);
         }
       
      
        catch(SQLException e){
         System.out.print(e);
        }
    return flag;
     
    }
    
    public static List<User> regusers() throws IOException {
      
  User user = null;
    ArrayList<User> reguser = new ArrayList<>();      
try{   
        Connection con = DbConnection.getConnection();
            System.out.println("connection"+con);
            String sql = "select id,firstname,lastname,contact,email from userdata";   
              
               PreparedStatement ps = con.prepareStatement(sql);
               ResultSet rs = ps.executeQuery();
       
               while(rs.next()){
                   
                   user=new User();
               int id=rs.getInt("id");
               String fname=rs.getString("firstname");
               String lname= rs.getString("lastname");
               String contact=rs.getString("contact");
               String email=rs.getString("email");
             
              user.setId(id);
              user.setFirstname(fname);
              user.setLastname(lname);
              user.setContact(contact);
              user.setEmail(email);
                      
reguser.add(user);
             }
            
         }catch(Exception e){
            out.print(e);
           }     
return reguser; 
    }

    public static boolean removeItem(int food_id) {
    boolean flag = true;
        Connection con = DbConnection.getConnection();
            System.out.println("connection"+con);
            try{
             String sql="delete from foodmenu where food_id="+food_id;
            PreparedStatement ps = con.prepareStatement(sql);
                 
             ps.executeUpdate();
    }catch(Exception e){
      out.print(e);
    }
            return flag;
    }

    public static FoodMenu getFoodItemById(int id) {
               
  FoodMenu foodmenu  = null;
  
        try{   
             Connection con = DbConnection.getConnection();
            System.out.println("connection"+con);
            String sql = "select * from foodmenu where food_id="+id;   
              
               PreparedStatement ps = con.prepareStatement(sql);
               ResultSet rs = ps.executeQuery();
            
               while(rs.next()){
                   foodmenu=new FoodMenu();
               String foodname=rs.getString("food_name");
               String dbfoodcategory=rs.getString("category");
               int dbprice= rs.getInt("price");
               int dbquantity=rs.getInt("quantity");
               int dbfooditemid=rs.getInt("food_id");
               String dbdescription=  rs.getString("description");
             
                out.print("got item of id"+dbfooditemid); 
                out.print(foodname); 
                out.print(dbprice); 
                out.print(dbquantity); 
                foodmenu.setFood_id(dbfooditemid);
                foodmenu.setFood_name(foodname);
                foodmenu.setCategory(dbfoodcategory);
                foodmenu.setPrice(dbprice);
                foodmenu.setQuantity(dbquantity);
                foodmenu.setDescription(dbdescription);
                
           
                                

             }    
         }catch(Exception e){
            out.print(e);
           }     
return foodmenu; 
    }

   

    public static ArrayList<Integer> viewFoodOrders() {
           ArrayList<Integer> orderlist=new ArrayList();
        Connection conn = DbConnection.getConnection();
        System.out.println("connection" + conn);
        String sql = "select orderid from orderfood";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet result = ps.executeQuery();
            while (result.next()) {
            
               int dborderid=result.getInt("orderid");
               
            System.out.print("orderid"+dborderid);
                orderlist.add(dborderid);
    }
        }  catch (Exception e) {
            System.out.print(e);
        }
        
        return orderlist;
    }


    public static List<FoodMenu> searchFood(String search) {
    
          FoodMenu foodMenu = null;
        List<FoodMenu> food = new ArrayList<>();
        Connection conn = DbConnection.getConnection();
        System.out.println("connection" + conn);
        System.out.print("searched item is "+search);
        String sql = "select * from foodmenu where food_name LIKE '%"+search+"%' OR "+"category LIKE '%"+search+"%'" ;

             try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                foodMenu = new FoodMenu();
                String dbitemname = rs.getString("food_name");
                String dbfoodcategory = rs.getString("category");
                int dbprice = rs.getInt("price");
                int dbquantity = rs.getInt("quantity");
                int dbfooditemid = rs.getInt("food_id");
                String dbdescription = rs.getString("description");
                Blob blob = rs.getBlob("image");

                foodMenu.setFood_id(dbfooditemid);
                foodMenu.setFood_name(dbitemname);
                foodMenu.setCategory(dbfoodcategory);
                foodMenu.setPrice(dbprice);
                foodMenu.setQuantity(dbquantity);
                foodMenu.setDescription(dbdescription);

                food.add(foodMenu);
                 
            }

        } catch (SQLException e) {
            System.out.print(e);
        }

        return food;
              

    }

    public static int addOrder(Order order) {
        int autoGeneratedID = 0;
          Connection conn = DbConnection.getConnection();
        System.out.println("connection" + conn);
        String sql = "insert into orderfood (id,flatno,streetname,area,landmark,city,totalcost,foodList) values(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

           ps.setInt(1,order.getUserid());
           ps.setString(2, order.getFlatno());
           ps.setString(3, order.getStreetName());
           ps.setString(4, order.getArea());
           ps.setString(5, order.getLandmark());
           ps.setString(6, order.getCity());
           ps.setInt(7,order.getTotalcost());
           
         
            String foodList = "";
    for(Object foodmenu : order.getFoodList()) { 
        FoodMenu menu=(FoodMenu) foodmenu;
          Integer foodid = menu.getFood_id();

        if(foodList.equals("")) {
            foodList=""+foodid;
        } else {
            foodList += "," + foodid;
            
        }
    } 
    ps.setString(8,foodList); 
    ps.executeBatch(); 
    ps.executeUpdate(); 
           
            ResultSet tablekeys = ps.getGeneratedKeys();
            tablekeys.next();
            autoGeneratedID = tablekeys.getInt(1);
            System.out.print("autogen id is" + autoGeneratedID);

        } catch (SQLException e) {
            System.out.print(e);
        }
return autoGeneratedID;
    }


    public static Order getOrderRecord(int orderid) {
     
     Order order= null;
        ArrayList foodmenu=null;
        Connection conn = DbConnection.getConnection();
        System.out.println("connection" + conn);
         try {
            
        String sql = "select * from orderfood where orderid="+orderid;
 
            PreparedStatement ps = conn.prepareStatement(sql);

              ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                order= new Order();
               int dborderid=rs.getInt("orderid");
               int dbuserid=rs.getInt("id");
               String dbflatno=rs.getString("flatno");
               String dbstreetname=rs.getString("streetname");
               String dbarea=rs.getString("area");
               String dbcity=rs.getString("city");
               String dblandmark=rs.getString("landmark");
               int dbtotalcost=rs.getInt("totalcost");
                String dbfoodList=rs.getString("foodList");
                Timestamp orderdate = rs.getTimestamp("orderdate");
                System.out.println("orderdate is" + orderdate);
                System.out.println("foodlist" +dbfoodList);
                order.setOrderid(dborderid);
                order.setUserid(dbuserid);
                order.setFlatno(dbflatno);
                order.setStreetName(dbstreetname);
                order.setArea(dbarea);
                order.setLandmark(dblandmark);
                order.setCity(dbcity);
                order.setTotalcost(dbtotalcost);
                order.setOrderdate(orderdate);
                String foodids[]=dbfoodList.split(",");
                
                for(String id:foodids)
                {
                    if(foodmenu==null)
                    {
                        foodmenu=new ArrayList();
                    }
                    
                    foodmenu.add(getFoodItemById(Integer.parseInt(id)));
                }
                order.setFoodList(foodmenu);
             
    }
        }  catch (SQLException | NumberFormatException e) {
            System.out.print(e);
        }
        return order;

    }

    public static void cancelOrder(int id) {
       Connection conn = DbConnection.getConnection();
        System.out.println("connection" + conn);
        String sql ="delete  from orderfood where orderid="+id;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

        
           ps.executeUpdate();
                }  catch (Exception e) {
            System.out.print(e);
        }
 
    }
    public static User getUser(int id) {
    
    User user=null;
         Connection conn = DbConnection.getConnection();
        System.out.println("connection" + conn);
        String sql = "select * from userdata where id="+id;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                user=new User();
                int dbid=result.getInt("id");
                String dbfirstname=result.getString("firstname");
                String dblastname=result.getString("lastname");
                String dbemail=result.getString("email");
                String dbcontact=result.getString("contact");
                String password=result.getString("password");
                user.setId(dbid);
                user.setFirstname(dbfirstname);
                user.setLastname(dblastname);
                user.setEmail(dbemail);
                user.setContact(dbcontact);
                user.setPassword(password);
                
            }
               

        } catch (SQLException e) {
            System.out.print(e);
        }
        
        return user;
    
        

    }

    public static void updatePassword(User user) {
         Connection conn=DbConnection.getConnection();
        System.out.println("connection"+conn);
        String npassword=user.getPassword();
        String cpassword=user.getCpassword();
       String email=user.getEmail();
      
        String sql="update userdata set password=?,cpassword=? where email=?";
   
     try{
        PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, npassword);
            ps.setString(2, cpassword);
            ps.setString(3,email);
            ps.executeUpdate();
             
         }
       
      
        catch(SQLException e){
         System.out.print(e);
        }

}

    public static int getId(User user) {
         Connection conn = DbConnection.getConnection();
          String email=user.getEmail();
        System.out.println("connection" + conn);
        String sql = "select id from userdata where email="+email;
int dbid=-1;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                user=new User();
                 dbid=result.getInt("id");
               
                
            }
               

        } catch (SQLException e) {
            System.out.print(e);
        }
        return dbid;
    }

    public static Order getOrderRecordById(int orderid) {
    
       Order order= null;
        ArrayList foodmenu=null;
        Connection conn = DbConnection.getConnection();
        System.out.println("connection" + conn);
        String sql = "select * from orderfood where orderid="+orderid;

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet result = ps.executeQuery();
            while (result.next()) {
                order= new Order();
           
               int dbuserid=result.getInt("id");
               String dbflatno=result.getString("flatno");
               String dbstreetname=result.getString("streetname");
               String dbarea=result.getString("area");
               String dbcity=result.getString("city");
               String dblandmark=result.getString("landmark");
               int dbtotalcost=result.getInt("totalcost");
                String dbfoodList=result.getString("foodList");
                order.setOrderid(orderid);
                order.setUserid(dbuserid);
                order.setFlatno(dbflatno);
                order.setStreetName(dbstreetname);
                order.setArea(dbarea);
                order.setLandmark(dblandmark);
                order.setCity(dbcity);
                order.setTotalcost(dbtotalcost);
                String foodids[]=dbfoodList.split(",");
                
                for(String foodid:foodids)
                {
                    if(foodmenu==null)
                    {
                        foodmenu=new ArrayList();
                    }
                    foodmenu.add(getFoodItemById(Integer.parseInt(foodid)));
                }
                order.setFoodList(foodmenu);
                
    }
        }  catch (SQLException | NumberFormatException e) {
            System.out.print(e);
        }
        return order;

    }

    public static void updateUser(User user) {
       
        Connection conn=DbConnection.getConnection();
        System.out.println("connection"+conn);
        int id=user.getId();
        String firstname=user.getFirstname();
       String lastname=user.getLastname();
       String email=user.getEmail();
       String contact=user.getContact();
        String sql="update userdata set firstname=?,lastname=?,email=?,contact=? where id="+id;
   
     try{
        PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, firstname);
         
            ps.setString(2, lastname);
             ps.setString(3, email);
              ps.setString(4, contact);
        ps.execute();
             
         }
       
      
        catch(SQLException e){
         System.out.print(e);
        }
 
}
}

    
    
   

   
   



       
