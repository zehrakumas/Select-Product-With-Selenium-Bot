public class addProductTest extends baseTest{
    public static void main(String[] args){
        baseTest baseTestmethod=new baseTest();
        baseTestmethod.setup();
        baseTestmethod.accept();
        baseTestmethod.searchClick();
        baseTestmethod.productSelect();
        baseTestmethod.productAdd();
        baseTestmethod.goToBasket();
    }
}
