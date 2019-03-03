package com.lydiagetachew;

public class Borrow {

    private String Borrower_id;
    private String Book_id;
    private String id;
    private String librarian_id;
    private String borrowed_date;
    private String return_date;
    private String status;


    public  Borrow(String Borrower_id,String Book_id,String id,String librarian_id,String borrowed_date,String return_date,String status)
    {
        this.Borrower_id=Borrower_id;
        this.Book_id=Book_id;
        this.id=id;
        this.librarian_id=librarian_id;
        this.borrowed_date=borrowed_date;
        this.return_date=return_date;
        this.status=status;
    }

    Borrow() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public void setBorrower_id(String Borrower_id)
    {
        this.Borrower_id=Borrower_id;
    }
    public String getBorrower_id()
    {
        return Borrower_id;
    }

    public void setBook_id(String Book_id)
    {
        this.Book_id=Book_id;
    }
    public String getBook_id()
    {
        return Book_id;
    }

    public void setId(String id)
    {
        this.id=id;
    }
    public String getId()
    {
        return id;
    }
    public void setlibrarian_id(String librarian_id)
    {
        this.librarian_id=librarian_id;
    }
    public String getlibrarian_id()
    {
        return librarian_id;
    }
    public void setborrowed_date(String borrowed_date)
    {
        this.borrowed_date=borrowed_date;
    }
    public String getborrowed_date()
    {
        return borrowed_date;
    }

    public void setreturn_date(String return_date)
    {
        this.return_date=return_date;
    }
    public String getreturn_date()
    {
        return return_date;
    }

    public void setstatus(String status)
    {
        this.status=status;
    }
    public String getstatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return " ||ID= " + id + "\t|| Borrower id > " + Borrower_id + "|| Book id > " + Book_id + "  || Librarian ID >"+librarian_id+"  ||Borrowed date "+borrowed_date+"  ||Returned date "+return_date +"\tStatus "+status+"]\n";
    }
}