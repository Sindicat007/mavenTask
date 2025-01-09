import org.jdom2.Document;

import org.jdom2.Element;

import org.jdom2.input.SAXBuilder;

import java.io.File;

import java.util.List;

public class App {

    public static void main(String[] args) {

        try {
            // Путь к XML-файлу

            File xmlFile = new File("src/main/resources/data.xml");

            // Создание парсера

            SAXBuilder saxBuilder = new SAXBuilder();


            // Чтение XML в документ

            Document document = saxBuilder.build(xmlFile);


            // Получение корневого элемента

            Element rootElement = document.getRootElement();
            System.out.println("Root Element: " + rootElement.getName());


            // Получение всех сотрудников

            List<Element> employees = rootElement.getChildren("employee");

            // Вывод информации о каждом сотруднике

            for (Element employee : employees) {

                String name = employee.getChildText("name");

                String position = employee.getChildText("position");
                String salary = employee.getChildText("salary");


                System.out.println("Employee:");

                System.out.println("  Name: " + name);
                System.out.println("  Position: " + position);
                System.out.println("  Salary: " + salary);

            }

        } catch (Exception e) {

            System.err.println("Error reading XML: " + e.getMessage());
        }
    }
}