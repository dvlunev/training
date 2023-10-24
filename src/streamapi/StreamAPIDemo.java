package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamAPIDemo {
    public static void main(String[] args) {
        // создание списка специалистов
        List<Specialist> specialists = new ArrayList<>(List.of(
                new Specialist("Ivan Ivanov", 1000000, Speciality.BUSINESS_ANALYST),
                new Specialist("Petr Petrov", 1200000, Speciality.PROJECT_MANAGER),
                new Specialist("Alexandr Alexandrov", 1050000, Speciality.DESIGNER),
                new Specialist("Dmitrii Dmitriev", 1050000, Speciality.DESIGNER),
                new Specialist("Alexey Alexeev", 1100000, Speciality.DEVELOPER),
                new Specialist("Nikolay Nikolaev", 900000, Speciality.DEVELOPER),
                new Specialist("Maria Ivanova", 950000, Speciality.DEVELOPER),
                new Specialist("Alexandra Alexandrova", 900000, Speciality.QA_ENGINEER)
        ));

        // ПРОМЕЖУТОЧНЫЕ ОПЕРАЦИИ
        // фильтр - filter
        List<Specialist> developers = StreamAPI.filterSpecialistsBySpeciality(specialists, Speciality.DEVELOPER);
        StreamAPI.forEachPrintSpecialists(developers);
        // сортировка по имени возрастание - sorted
        List<Specialist> sortedSpecialists = StreamAPI.sortedSpecialistsByName(developers);
        StreamAPI.forEachPrintSpecialists(sortedSpecialists);
        // сортировка по зп убывание - sorted - reversed
        List<Specialist> sortedSpecialists1 = StreamAPI.sortedSpecialistsBySalaryDesc(developers);
        StreamAPI.forEachPrintSpecialists(sortedSpecialists1);
        // создание второго списка специалистов
        List<Specialist> specialists1 = new ArrayList<>(List.of(
                new Specialist("Svetlana Alexeeva", 1050000, Speciality.BUSINESS_ANALYST),
                new Specialist("Alexandra Alexandrova", 900000, Speciality.QA_ENGINEER)
        ));
        // объединение потоков - concat
        List<Specialist> combinedSpecialistsList = StreamAPI.concatCombineSpecialists(specialists, specialists1);
        StreamAPI.forEachPrintSpecialists(combinedSpecialistsList);
        // получение уникальных данных - distinct
        List<Specialist> uniqueSpecialistsList = StreamAPI.distinctGetUniqueSpecialists(combinedSpecialistsList);
        StreamAPI.forEachPrintSpecialists(uniqueSpecialistsList);
        // пропуск пока соответствуют условию - doWhile
        List<Specialist> doWhileListTest = StreamAPI.dropWhileTest(specialists);
        StreamAPI.forEachPrintSpecialists(doWhileListTest);
        // оставляет в потоке определенное кол-во элементов - limit
        List<Specialist> limitElements = StreamAPI.limitElements(specialists);
        StreamAPI.forEachPrintSpecialists(limitElements);
        // преобразование элементов - map
        List<String> mapElements = StreamAPI.mapElements(specialists);
        System.out.println(mapElements);
        // преобразование элементов, список в списке - flatMap
        List<List<Specialist>> listOfListsSpecialists = new ArrayList<>(List.of(
                specialists,
                specialists1
        ));
        List<Specialist> flatMapElements = StreamAPI.flatMapElements(listOfListsSpecialists);
        StreamAPI.forEachPrintSpecialists(flatMapElements);
        // пропускает несколько первых элементов - skip
        List<Specialist> skipElements = StreamAPI.skipElements(specialists);
        StreamAPI.forEachPrintSpecialists(skipElements);
        // выбирает из потока элементы пока они соответствуют условию - takeWhile
        List<Specialist> takeWhileElements = StreamAPI.takeWhileElements(specialists);
        StreamAPI.forEachPrintSpecialists(takeWhileElements);

        System.out.println();

        // ТЕРМИНАЛЬНЫЕ ОПЕРАЦИИ
        // обход всех элементов и выполнения действия - forEach
        StreamAPI.forEachPrintSpecialists(specialists);
        // поиска максимума - max
        Specialist maxSalarySpecialist = StreamAPI.maxFindSpecialistWithMaxSalary(developers);
        System.out.println(maxSalarySpecialist);
        // поиска минимума - min
        Specialist minSalarySpecialist = StreamAPI.minFindSpecialistWithMinSalary(developers);
        System.out.println(minSalarySpecialist);
        // подсчет количества - count
        long count = StreamAPI.countSpecialistWithSalaryOverMill(specialists);
        System.out.println("Amount specialists with salary 1 000 000 and over " + count);
        // проверка что все элементы потока удовлетворяют условию - allMatch
        boolean allMatchCheck = StreamAPI.allMatchIsAllHaveSalaryOver900k(specialists);
        System.out.println("Is all have salary over 900k " + allMatchCheck);
        // проверка на то, что хоть один элемент потока удовлетворяют условию в предикате - anyMatch
        boolean anyMatchCheck = StreamAPI.anyMatchIsTeamHasBusinessAnalyst(specialists);
        System.out.println("Is team has business analyst " + anyMatchCheck);
        // поиск первого элемента - findFirst
        Optional<Specialist> firstSpecialistOptional = StreamAPI.findFirstSpecialist(doWhileListTest);
        firstSpecialistOptional.ifPresent(System.out::println);
        // поиск любого элемента - findAny
        Optional<Specialist> anySpecialistOptional = StreamAPI.findAnySpecialist(doWhileListTest);
        anySpecialistOptional.ifPresent(s -> System.out.println(s));
        // проверка что не один элемент не удовлетворяет условию - noneMatch
        boolean noneMatchCheck = StreamAPI.noneMatchCheck(specialists);
        System.out.println("Is all have not salary over 2 000 000 " + noneMatchCheck);
        // возвращает массив элементов потока - toArray
        Object[] arrSpecialists = StreamAPI.toArraySpecialists(specialists);
        System.out.println(Arrays.toString(arrSpecialists));
    }
}