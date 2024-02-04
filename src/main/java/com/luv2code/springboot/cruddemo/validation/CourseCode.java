package com.luv2code.springboot.cruddemo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * {@link Constraint }Bu satır, CourseCode anotasyonunun hangi sınıf tarafından uygulanacağını belirtir.
 * Burada CourseCodeContraintValidator sınıfı, özel doğrulama kuralını uygulayan bir sınıf olmalıdır.
 */
@Constraint(validatedBy = CourseCodeContraintValidator.class)

/**
 * {@link Target} Bu satır, CourseCode anotasyonunun hangi türde elemanlara uygulanabileceğini belirtir.
 * Bu durumda, alanlara ve metotlara uygulanabilir.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
/**
 * {@link Retention} Bu satır, CourseCode anotasyonunun çalışma zamanında kullanılabilir olduğunu belirtir.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode { //Bu anotasyon, özel doğrulama kurallarını tanımlayan bir arayüz oluşturur.

    //define default course code

    public String value() default "luv"; //varsayılan olarak belirlenmiş bir kurs kodu tanımlar. Bu değer, anotasyon kullanıcıları tarafından belirtilmezse kullanılacaktır.

    //define default error message

    public String message() default "must start with luv";//varsayılan bir hata mesajını tanımlar. Bu mesaj, doğrulama kuralının ihlal edildiğinde kullanıcıya gösterilecek olan mesajdır.

    //define default groups

    public Class<?>[] groups() default {};// varsayılan olarak belirlenmiş grupları tanımlar. Gruplar, doğrulama kuralının hangi gruplara ait nesneler üzerinde uygulanacağını belirlemek için kullanılır.

    //define default payloads

    public Class<? extends Payload>[] payload() default {};//varsayılan olarak belirlenmiş payload'ları tanımlar. Payload'lar, doğrulama kuralının nasıl uygulanacağını belirleyen ek bilgiler içerebilir.

}
