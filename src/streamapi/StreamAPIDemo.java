package streamapi;

import java.util.*;

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
        System.out.println("ПРОМЕЖУТОЧНЫЕ ОПЕРАЦИИ");
        // фильтр - filter
        System.out.println("filter");
        List<Specialist> developers = StreamAPI.filterSpecialistsBySpeciality(specialists, Speciality.DEVELOPER);
        StreamAPI.forEachPrintSpecialists(developers);
        // сортировка по имени возрастание - sorted
        System.out.println("sorted inc");
        List<Specialist> sortedSpecialists = StreamAPI.sortedSpecialistsByName(developers);
        StreamAPI.forEachPrintSpecialists(sortedSpecialists);
        // сортировка по зп убывание - sorted - reversed
        System.out.println("sorted reversed");
        List<Specialist> sortedSpecialists1 = StreamAPI.sortedSpecialistsBySalaryDesc(developers);
        StreamAPI.forEachPrintSpecialists(sortedSpecialists1);
        // создание второго списка специалистов
        List<Specialist> specialists1 = new ArrayList<>(List.of(
                new Specialist("Svetlana Alexeeva", 1050000, Speciality.BUSINESS_ANALYST),
                new Specialist("Alexandra Alexandrova", 900000, Speciality.QA_ENGINEER)
        ));
        // объединение потоков - concat
        System.out.println("concat");
        List<Specialist> combinedSpecialistsList = StreamAPI.concatCombineSpecialists(specialists, specialists1);
        StreamAPI.forEachPrintSpecialists(combinedSpecialistsList);
        // получение уникальных данных - distinct
        System.out.println("distinct");
        List<Specialist> uniqueSpecialistsList = StreamAPI.distinctGetUniqueSpecialists(combinedSpecialistsList);
        StreamAPI.forEachPrintSpecialists(uniqueSpecialistsList);
        // пропуск пока соответствуют условию - doWhile
        System.out.println("doWhile");
        List<Specialist> doWhileListTest = StreamAPI.dropWhileTest(specialists);
        StreamAPI.forEachPrintSpecialists(doWhileListTest);
        // оставляет в потоке определенное кол-во элементов - limit
        System.out.println("limit");
        List<Specialist> limitElements = StreamAPI.limitElements(specialists);
        StreamAPI.forEachPrintSpecialists(limitElements);
        // преобразование элементов - map
        System.out.println("map");
        List<String> mapElements = StreamAPI.mapElements(specialists);
        System.out.println(mapElements);
        // преобразование элементов, список в списке - flatMap
        System.out.println("flatMap");
        List<List<Specialist>> listOfListsSpecialists = new ArrayList<>(List.of(
                specialists,
                specialists1
        ));
        List<Specialist> flatMapElements = StreamAPI.flatMapElements(listOfListsSpecialists);
        StreamAPI.forEachPrintSpecialists(flatMapElements);
        // пропускает несколько первых элементов - skip
        System.out.println("skip");
        List<Specialist> skipElements = StreamAPI.skipElements(specialists);
        StreamAPI.forEachPrintSpecialists(skipElements);
        // выбирает из потока элементы пока они соответствуют условию - takeWhile
        System.out.println("takeWhile");
        List<Specialist> takeWhileElements = StreamAPI.takeWhileElements(specialists);
        StreamAPI.forEachPrintSpecialists(takeWhileElements);
        // выполнение дейстия над каждым элементом - peek
        System.out.println("peek");
        List<Specialist> peekElements = StreamAPI.peekElements(takeWhileElements);
        StreamAPI.forEachPrintSpecialists(peekElements);

        System.out.println();

        // ТЕРМИНАЛЬНЫЕ ОПЕРАЦИИ
        System.out.println("ТЕРМИНАЛЬНЫЕ ОПЕРАЦИИ");
        // обход всех элементов и выполнения действия - forEach
        StreamAPI.forEachPrintSpecialists(specialists);
        // поиска максимума - max
        System.out.println("max");
        Specialist maxSalarySpecialist = StreamAPI.maxFindSpecialistWithMaxSalary(developers);
        System.out.println(maxSalarySpecialist);
        // поиска минимума - min
        System.out.println("min");
        Specialist minSalarySpecialist = StreamAPI.minFindSpecialistWithMinSalary(developers);
        System.out.println(minSalarySpecialist);
        // подсчет количества - count
        System.out.println("count");
        long count = StreamAPI.countSpecialistWithSalaryOverMill(specialists);
        System.out.println("Amount specialists with salary 1 000 000 and over " + count);
        // проверка что все элементы потока удовлетворяют условию - allMatch
        System.out.println("allMatch");
        boolean allMatchCheck = StreamAPI.allMatchIsAllHaveSalaryOver900k(specialists);
        System.out.println("Is all have salary over 900k " + allMatchCheck);
        // проверка на то, что хоть один элемент потока удовлетворяют условию в предикате - anyMatch
        System.out.println("anyMatch");
        boolean anyMatchCheck = StreamAPI.anyMatchIsTeamHasBusinessAnalyst(specialists);
        System.out.println("Is team has business analyst " + anyMatchCheck);
        // поиск первого элемента - findFirst
        System.out.println("findFirst");
        Optional<Specialist> firstSpecialistOptional = StreamAPI.findFirstSpecialist(doWhileListTest);
        firstSpecialistOptional.ifPresent(System.out::println);
        // поиск любого элемента - findAny
        System.out.println("findAny");
        Optional<Specialist> anySpecialistOptional = StreamAPI.findAnySpecialist(doWhileListTest);
        anySpecialistOptional.ifPresent(s -> System.out.println(s));
        // проверка что не один элемент не удовлетворяет условию - noneMatch
        System.out.println("noneMatch");
        boolean noneMatchCheck = StreamAPI.noneMatchCheck(specialists);
        System.out.println("Is all have not salary over 2 000 000 " + noneMatchCheck);
        // возвращает массив элементов потока - toArray
        System.out.println("toArray");
        Object[] arrSpecialists = StreamAPI.toArraySpecialists(specialists);
        System.out.println(Arrays.toString(arrSpecialists));
        // сокращение элементов до одного значения - reduce
        System.out.println("reduce");
        Optional<Integer> totalSalary = StreamAPI.reduceElemetsToTotalSalary(specialists);
        totalSalary.ifPresent(s -> System.out.println("Total salary: " + s));
        // создание параллельного потока, поддержание порядка элементов при параллельной обработки - parallel, forEachOrdered
        System.out.println("parallel, forEachOrdered");
        StreamAPI.parallelAndForEachOrderedPrintSpecialists(specialists);

        System.out.println();

        // ГРУППИРОВКА
        System.out.println("ГРУППИРОВКА");
        // группировка элементов по ключу - Collectors.groupingBy
        System.out.println("Collectors.groupingBy");
        Map<Speciality, List<Specialist>> groupedBySpeciality = StreamAPI.groupBySpeciality(specialists);
        System.out.println(groupedBySpeciality);
        // разделение элементов на две группы - Collectors.partitioningBy
        System.out.println("Collectors.partitioningBy");
        Map<Boolean, List<Specialist>> groupedBySalaryOver1MillOrNot = StreamAPI.groupBySalaryOver1MillOrNot(specialists);
        System.out.println(groupedBySalaryOver1MillOrNot);
        // преобразование потока в примитивный поток - mapToInt и получение статистики summaryStatistics
        System.out.println("mapToInt & summaryStatistics");
        IntSummaryStatistics intSummaryStatistics = StreamAPI.getIntSummaryStatistics(specialists);
        System.out.println("Sum " + intSummaryStatistics.getSum());
        System.out.println("Max " + intSummaryStatistics.getMax());
        System.out.println("Min " + intSummaryStatistics.getMin());
        System.out.println("Average " + intSummaryStatistics.getAverage());
        System.out.println("Count " + intSummaryStatistics.getCount());
    }
}