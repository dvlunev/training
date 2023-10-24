package streamapi;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream API - способ работы с данными в функциональном стиле, создание потока данных и его обработка
 * Источник данных - из чего формируется стрим, пустой стрим, List, Map, массив, указанные элементы
 * Промежуточная операция - может быть сколько угодно, производят некоторые действия над объектами стрима
 * Терминальная операция - может быть только один, запускает работу стрима и завершает ее
 */
public class StreamAPI {

    // ПРОМЕЖУТОЧНЫЕ ОПЕРАЦИИ
    /**
     * filter - промежуточная операция, фильтр по специальностям с лямбда-выражением, отбираются те специалисты, которые соответствуют условию;
     * collect - терминальная операция, формирует стрим в коллекцию с помощью коллектора в список
     *
     * @param specialists список специалистов
     * @param speciality  специальность по которой происходит фильтр
     * @return список специалистов после выполнения стрима
     */
    public static List<Specialist> filterSpecialistsBySpeciality(List<Specialist> specialists, Speciality speciality) {
        return specialists.stream()
                .filter(specialist -> specialist.getSpeciality().equals(speciality))
                .collect(Collectors.toList());
    }

    /**
     * sorted - промежуточная операция, сортировка объектов с использованием компаратора, в котором задается параметр сортировки по имени;
     * collect - терминальная операция, формирует стрим в коллекцию с помощью коллектора в список
     *
     * @param specialists список специалистов
     * @return список специалистов после выполнения стрима
     */
    public static List<Specialist> sortedSpecialistsByName(List<Specialist> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(specialist -> specialist.getName()))
//                .sorted(Comparator.comparing(Specialist::getName))
                .collect(Collectors.toList());
    }

    /**
     * sorted - промежуточная операция, сортировка объектов с использованием компаратора, в котором задается параметр сортировки по имени;
     * collect - терминальная операция, формирует стрим в коллекцию с помощью коллектора в список
     * @param specialists список специалистов
     * @return список специалистов после выполнения стрима
     */
    public static List<Specialist> sortedSpecialistsBySalaryDesc(List<Specialist> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Specialist::getSalary).reversed())
                .collect(Collectors.toList());
    }

    /**
     * concat - промежуточная операция, объединяет два потока
     * @param specialists1 список специалистов 1
     * @param specialists2 список специалистов 2
     * @return список специалистов после объединения
     */
    public static List<Specialist> concatCombineSpecialists(List<Specialist> specialists1, List<Specialist> specialists2) {
        Stream<Specialist> specialists1Stream = specialists1.stream();
        Stream<Specialist> specialists2Stream = specialists2.stream();
        return Stream.concat(specialists1Stream, specialists2Stream).collect(Collectors.toList());

    }


    /**
     * distinct - промежуточная операция, возвращает потом с уникальными элементами
     * @param specialists список специалистов
     * @return список специалистов после отбора уникальных
     */
    public static List<Specialist> distinctGetUniqueSpecialists(List<Specialist> specialists) {
        return specialists.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * dropWhile - промежуточная операция, пропускает элементы подходящие по условию в предикате, пока не попадется неподходящий элемент
     * @param specialists список специалистов
     * @return список специалистов после пропуска
     */
    public static List<Specialist> dropWhileTest(List<Specialist> specialists) {
        return specialists.stream()
                .dropWhile(s -> s.getSalary() >= 1000000)
                .collect(Collectors.toList());
    }

    /**
     * limit - промежуточная операция, оставляет в потоке определенное количество элементов
     * @param specialists список специалистов
     * @return список специалистов в определенном количестве
     */
    public static List<Specialist> limitElements(List<Specialist> specialists) {
        return specialists.stream()
                .limit(2)
                .collect(Collectors.toList());
    }

    /**
     * map - промежуточная операция, преобразует элементы из одного типа в другой
     * @param specialists список специалистов
     * @return преобразованный список элементов
     */
    public static List<String> mapElements(List<Specialist> specialists) {
        return specialists.stream()
//                .map(Specialist::getName)
                .map(s -> s.getName())
                .collect(Collectors.toList());
    }

    /**
     * flatMap - промежуточная операция, преобразует элементы из одного типа в другой
     * @param listOfListsSpecialists список списков специалистов
     * @return преобразованный список специалистов
     */
    public static List<Specialist> flatMapElements(List<List<Specialist>> listOfListsSpecialists) {
        return listOfListsSpecialists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    /**
     * skip - промежуточная операция, возвращает поток с заданным количеством пропущенных первых элементов
     * @param specialists список специалистов
     * @return список специалистов с заданным количеством пропущенных первых элементов
     */
    public static List<Specialist> skipElements(List<Specialist> specialists) {
        return specialists.stream()
                .skip(3)
                .collect(Collectors.toList());
    }

    /**
     * takeWhile - промежуточная операция, выбирает из потока элементы, пока они соответсвуют условию в предикате
     * @param specialists список специалистов
     * @return список специалистов после отбора
     */
    public static List<Specialist> takeWhileElements(List<Specialist> specialists) {
        return specialists.stream()
                .takeWhile(s -> s.getSalary() >= 1000000)
                .collect(Collectors.toList());
    }

    // ТЕРМИНАЛЬНЫЕ ОПЕРАЦИИ
    /**
     * forEach - терминальная операция, обходит все объекты стрима и производит с ними какие либо действия,
     * в данном случае используется лямбда-выдажение, выводятся в консоль все специалисты
     *
     * @param specialists список специалистов
     */
    public static void forEachPrintSpecialists(List<Specialist> specialists) {
        Stream.of(specialists)
                .forEach(specialist -> System.out.println(specialist.toString()));
    }

    /**
     * max = терминальная операция, находит объект, с максимальным значением с использованием компаратора, в котором задается параметр по которому происходит сравнение
     * @param specialists список специалистов
     * @return специалист после выполнения стрима
     */
    public static Specialist maxFindSpecialistWithMaxSalary(List<Specialist> specialists) {
        return specialists.stream()
                .max(Comparator.comparing(specialist -> specialist.getSalary())).orElse(null);
    }

    /**
     * min = терминальная операция, находит объект, с минимальным значением с использованием компаратора, в котором задается параметр по которому происходит сравнение
     * @param specialists список специалистов
     * @return специалист после выполнения стрима
     */
    public static Specialist minFindSpecialistWithMinSalary(List<Specialist> specialists) {
        return specialists.stream()
                .min(Comparator.comparing(specialist -> specialist.getSalary())).orElse(null);
    }

    /**
     * count - терминальная операция, врозвращает количество элементов в стриме
     * @param specialists список специалистов
     * @return количество специалистов с ЗП более 1 млн
     */
    public static long countSpecialistWithSalaryOverMill(List<Specialist> specialists) {
        return specialists.stream()
                .filter(s -> s.getSalary() >= 1000000)
                .count();
    }

    /**
     * allMatch - терминальная операция, возвращает true, если все элементы потока удовлетворяют условию в предикате
     * @param specialists список специалистов
     * @return возвращает true, если все элементы потока удовлетворяют условию
     */
    public static boolean allMatchIsAllHaveSalaryOver900k(List<Specialist> specialists) {
        return specialists.stream()
                .allMatch(s -> s.getSalary() >= 900000);
    }

    /**
     * anyMatch - терминальная операция, возвращает true, хоть один элемент потока удовлетворяют условию в предикате
     * @param specialists список специалистов
     * @return возвращает true, если хоть один элемент потока удовлетворяют условию в предикате
     */
    public static boolean anyMatchIsTeamHasBusinessAnalyst(List<Specialist> specialists) {
        return specialists.stream()
                .anyMatch(s -> s.getSpeciality().equals(Speciality.BUSINESS_ANALYST));
    }

    /**
     * findFirst - терминальная операция, возвращает первый элемент из потока
     * @param specialists список специалистов
     * @return первый специалист в списке
     */
    public static Optional<Specialist> findFirstSpecialist(List<Specialist> specialists) {
        return specialists.stream()
                .findFirst();
    }

    /**
     * findAny - терминальная операция, возвращает любой элемент из потока
     * @param specialists список специалистов
     * @return любой специалист в списке
     */
    public static Optional<Specialist> findAnySpecialist(List<Specialist> specialists) {
        return specialists.stream()
                .findAny();
    }

    /**
     * noneMatch - терминальная операция, возвращает true, если все элементы потока НЕ удовлетворяют условию в предикате
     * @param specialists список специалистов
     * @return возвращает true, если все элементы потока НЕ удовлетворяют условию
     */
    public static boolean noneMatchCheck(List<Specialist> specialists) {
        return specialists.stream()
                .noneMatch(s -> s.getSalary() > 2000000);
    }

    /**
     * toArray - терминальная операция, возвращает массив элементов потока
     * @param specialists список специалистов
     * @return массив элементов потока
     */
    public static Object[] toArraySpecialists(List<Specialist> specialists) {
        return specialists.stream()
                .filter(s -> s.getSalary() < 1000000)
                .toArray();
    }
}
