package lt.itmokymai.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//Uzduotis 2. prieš bean kuriantis, išvesti bean vardą
//bean susikūrus, pranešti apie tai, kad bean sukurtas
//pranešime turi figūruoti bean vardas
//po bean sunaikinimo išvesti tekstą, kad bean susinaikino
//pranešime turi figūruoti bean vardas

//is 52 skaidres:
public class InitHelloWorld implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Uzduotis 2. BeforeInitialization: " + beanName);
		return bean; // you can return any other object as well
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Uzduotis 2. AfterInitialization : " + beanName);
		return bean; // you can return any other object as well
	}
}
