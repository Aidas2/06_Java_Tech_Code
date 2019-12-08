package lt.itmokymai.spring;
//Uzduotis 3_03. Sukurti lt.itmokymai.spring.ServiceC klasę, kuri paveldėtų lt.itmokymai.spring.ServiceA klasę.
/*
public class ServiceC extends ServiceA {


}
*/

//Uzduotis 3_04. Perkrauti ServiceC.getResult() metodą:
public class ServiceC extends ServiceA {

@Override
public String getResult() {
return "Uzduotis 3_04. ServiceC result:"+getMessage();
}

}
