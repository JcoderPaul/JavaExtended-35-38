******* Class Scanner - Класс сканер *******

Наследует и реализует: public final class Scanner
                       extends Object
                       implements Iterator<String>, Closeable

Класс Scanner упрощает разбор строки из потока ввода, позволяя обойтись без
классов BufferedReader, InputStreamReader. В качестве входных объектов можно
использовать File, InputStream, String, Readable. В учебных примерах часто
используют System.in в качестве приёма данных от настольной клавиатуры, что не
слишком актуально, например для Android.

Метод next() возвращает следующую лексему String, также существуют методы для
примитивных типов, например, nextInt(). Метод выполняется в блокирующем режиме.
Также существуют соответствующие методы hasNext(), которые возвращают true, если
следующая лексема относится к правильному типу.

По умолчанию входные данные разбиваются по пробелам между словами. Можно задать
собственный разделитель в форме регулярного выражения в методе useDelimiter().

Простой текстовый сканер, который может анализировать примитивные типы и строки
с помощью регулярных выражений. Scanner разбивает входные данные на токены,
используя шаблон разделителя, который по умолчанию соответствует пробелу.
Полученные токены затем могут быть преобразованы в значения различных типов с
использованием различных методов next.

******* Простой ввод данных с консоли *******

Для получения ввода с консоли в классе System определен объект in. Однако
непосредственно через объект System.in не очень удобно работать, поэтому,
как правило, используют класс Scanner, который, в свою очередь использует
System.in.

Например, этот код позволяет пользователю прочитать число из System.in:
------------------------------------------------------------------------
Scanner sc = new Scanner(System.in);
int num = sc.nextInt();
------------------------------------------------------------------------

Так как класс Scanner находится в пакете java.util, то мы вначале его
импортируем с помощью инструкции import java.util.Scanner. Для создания
самого объекта Scanner в его конструктор передается объект System.in.
После этого мы можем получать вводимые значения. Например, в данном случае
вначале выводим приглашение к вводу и затем получаем вводимое число в
переменную num.

Чтобы получить введенное число, используется метод *.nextInt(), который
возвращает введенное с клавиатуры целочисленное значение.
(Более подробно см. Less_36_Scanner_Step1)

Для ввода значений каждого примитивного типа в классе Scanner определен
свой метод. Например, этот код позволяет считать тип long из файла
myNumbers переменную long:
------------------------------------------------------------------------
 Scanner sc = new Scanner(new File("myNumbers"));
      while (sc.hasNextLong()) {
          long aLong = sc.nextLong();
      }
------------------------------------------------------------------------

Сканер также может использовать разделители, отличные от пробелов. В этом
примере несколько элементов считываются из строки:
------------------------------------------------------------------------
String input = "1 fish 2 fish red fish blue fish";
     Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
     System.out.println(s.nextInt()); // 1
     System.out.println(s.nextInt()); // 2
     System.out.println(s.next()); // red
     System.out.println(s.next()); // blue
     s.close(); // Закрыли поток
------------------------------------------------------------------------

Точно такой же вывод на экран можно получить с помощью этого кода, который
использует регулярное выражение для одновременного анализа всех четырех
токенов:
------------------------------------------------------------------------
String input = "1 fish 2 fish red fish blue fish";
     Scanner s = new Scanner(input);
     s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
     MatchResult result = s.match();
     for (int i = 1; i <= result.groupCount(); i++)
         System.out.println(result.group(i));
     s.close();
------------------------------------------------------------------------

Пробел как разделитель по умолчанию, используемый сканером, распознается по
символу Character.isWhitespace. Метод *.reset() приведет к сбросу значения
разделителя сканера на разделитель пробелов по умолчанию, независимо от того,
был ли он изменен ранее.

Операция сканирования может блокировать ожидание ввода.

Методы *.next() и *.hasNext() и их сопутствующие методы примитивного типа
(такие, как *.nextInt() и *.hasNextInt()) сначала пропускают любой ввод,
соответствующий шаблону разделителя, а затем пытаются вернуть следующий токен.
Оба метода *.hasNext() и *.next() могут блокировать ожидание дальнейшего ввода.
Блокировка метода *.hasNext() не связана с тем, будет ли блокироваться связанный
с ним метод *.next().

Методы *.findInLine() (java.lang.String), *.findWithinHorizon() (java.lang.String, int)
и *.skip() (java.util.regex.Pattern) работают независимо от шаблона разделителя.
Эти методы будут пытаться сопоставить указанный шаблон независимо от разделителей
во входных данных и, таким образом, могут использоваться в особых случаях, когда
разделители не имеют значения. Эти методы могут блокировать ожидание ввода
дополнительных данных.

Когда сканер генерирует исключение InputMismatchException, сканер не передает токен,
вызвавший исключение, поэтому его можно получить или пропустить каким-либо другим
способом.

В зависимости от типа шаблона-разделителя могут быть возвращены пустые токены.
Например, шаблон "\\s+" не вернет пустых токенов, поскольку он соответствует нескольким
экземплярам разделителя. Шаблон разделителя "\\s" может возвращать пустые токены, так
как он передает только один пробел за раз.

Сканер может считывать текст с любого объекта, реализующего интерфейс Readable.
Если вызов базового метода чтения Readable.read (java.nio.CharBuffer) вызывает
исключение IOException, сканер предполагает, что достигнут конец ввода. Самое
последнее исключение IOException, созданное базовым объектом для чтения, может быть
получено с помощью метода ioException().

Когда сканер закрыт, он закроет свой источник ввода, если источник реализует
интерфейс Closeable.

Сканер небезопасен для многопоточного использования без внешней синхронизации.

Если не указано иное, передача нулевого параметра в любой метод сканера вызовет
исключение NullPointerException.

Сканер по умолчанию будет интерпретировать числа как десятичные, если с помощью
метода *.useRadix() (int) не было установлено другое основание счисления. Метод
*.reset() сбрасывает значение системы счисления сканера до 10 независимо от того,
было ли оно ранее изменено.

!!! *** Необходимо помнить, что для ввода значения типа float (то же самое относится
к типу double) применяется число "1,7", где разделителем является запятая, а не
"1.7", где разделителем является точка. В данном случае все зависит от текущей
языковой локализации системы. В случае русскоязычной локализация, соответственно
вводить необходимо числа, где разделителем является запятая. То же самое касается
многих других локализаций, например, немецкой, французской и т.д., где применяется
запятая. *** !!!

******* Доступные конструкторы *******

Scanner(File source) - Создает новый сканер, который создает значения,
                       отсканированные из указанного файла.

Scanner(File source, String charsetName) - Создает новый сканер, который
                                           создает значения, отсканированные
                                           из указанного файла.

Scanner(InputStream source) - Создает новый Scanner, который создает значения,
                              отсканированные из указанного входного потока.

Scanner(InputStream source, String charsetName) - Создает новый Scanner, который
                                                  создает значения, отсканированные
                                                  из указанного входного потока.

Scanner(Path source) - Создает новый сканер, который создает значения, отсканированные
                       из указанного файла.

Scanner(Path source, String charsetName) - Создает новый сканер, который создает
                                           значения, отсканированные из указанного
                                           файла.

Scanner(Readable source) - Создает новый сканер, который создает значения, отсканированные
                           из указанного источника.

Scanner(ReadableByteChannel source) - Создает новый сканер, который производит значения,
                                      отсканированные из указанного канала.
Scanner(ReadableByteChannel source, String charsetName) - Создает новый сканер, который
                                                          производит значения, отсканированные
                                                          из указанного канала.

Scanner(String source) - Создает новый Scanner, который создает значения, отсканированные из
                         указанной строки.

******* Методы класса Scanner *******

void close() - Закрывает этот сканер.
Pattern delimiter() - Возвращает шаблон, который этот сканер в настоящее время
                      использует для сопоставления разделителей.

String findInLine(Pattern pattern) - Пытается найти следующее вхождение указанного
                                     шаблона, игнорируя разделители.

String findInLine(String pattern) - Пытается найти следующее вхождение шаблона,
                                    созданного из указанной строки, игнорируя
                                    разделители.

String findWithinHorizon(Pattern pattern, int horizon) - Пытается найти следующее
                                                         вхождение указанного шаблона.

String findWithinHorizon(String pattern, int horizon) - Пытается найти следующее вхождение
                                                        шаблона, созданного из указанной
                                                        строки, игнорируя разделители.

boolean	hasNext() - Возвращает true, если этот сканер имеет другой токен на входе.
boolean	hasNext(Pattern pattern) - Возвращает true, если следующий полный токен соответствует
                                   указанному шаблону.

boolean	hasNext(String pattern) - Возвращает true, если следующий токен соответствует шаблону,
                                  построенному из указанной строки.

boolean	hasNextBigDecimal() - Возвращает true, если следующий токен во входных данных этого
                              сканера может быть интерпретирован как BigDecimal с помощью
                              метода nextBigDecimal().

boolean	hasNextBigInteger() - Возвращает true, если следующий токен во входных данных этого
                              сканера может быть интерпретирован как BigInteger в системе
                              счисления по умолчанию с использованием метода nextBigInteger().

boolean	hasNextBigInteger(int radix) - Возвращает true, если следующий токен во входных данных
                                       этого сканера может быть интерпретирован как BigInteger
                                       в указанной системе счисления с использованием метода
                                       nextBigInteger().

boolean	hasNextBoolean() - Возвращает true, если следующий токен во входных данных
                           этого сканера может быть интерпретирован как логическое
                           значение с использованием нечувствительного к регистру
                           шаблона, созданного из строки «true|false».

boolean	hasNextByte() - Возвращает true, если следующий токен во входных данных этого
                        сканера может быть интерпретирован как значение байта в системе
                        счисления по умолчанию с использованием метода nextByte().

boolean	hasNextByte(int radix) - Возвращает true, если следующий токен во входных данных
                                 этого сканера может быть интерпретирован как значение
                                 байта в указанной системе счисления с использованием
                                 метода nextByte().

boolean	hasNextDouble() - Возвращает true, если следующий токен во входных данных этого
                          сканера может быть интерпретирован как двойное значение с
                          использованием метода nextDouble().

boolean	hasNextFloat() - Возвращает true, если следующий токен во входных данных этого
                         сканера может быть интерпретирован как значение с плавающей
                         запятой с использованием метода nextFloat().

boolean	hasNextInt() - Возвращает true, если следующий токен во входных данных этого
                       сканера может быть интерпретирован как значение int в системе
                       счисления по умолчанию с использованием метода nextInt().

boolean	hasNextInt(int radix) - Возвращает true, если следующий токен во входных данных
                                этого сканера может быть интерпретирован как значение int
                                в указанной системе счисления с использованием метода
                                nextInt().

boolean	hasNextLine() - Возвращает true, если на входе этого сканера есть другая строка.
boolean	hasNextLong() - Возвращает true, если следующий токен во входных данных этого
                        сканера может быть интерпретирован как значение long в системе
                        счисления по умолчанию с использованием метода nextLong().

boolean	hasNextLong(int radix) - Возвращает true, если следующий токен во входных данных
                                 этого сканера может быть интерпретирован как значение
                                 long в указанной системе счисления с использованием
                                 метода nextLong().

boolean	hasNextShort() - Возвращает true, если следующий токен во входных данных этого
                         сканера может быть интерпретирован как значение short в системе
                         счисления по умолчанию с использованием метода nextShort().

boolean	hasNextShort(int radix) - Возвращает true, если следующий токен во входных данных
                                  этого сканера может быть интерпретирован как значение short
                                  в указанной системе счисления с использованием метода
                                  nextShort().

IOException	ioException() - Возвращает последнее исключение IOException, сгенерированное
                            базовым Readable этого сканера.

Locale	locale() - Возвращает локаль этого сканера.

MatchResult	match() - Возвращает результат сопоставления последней операции сканирования,
                      выполненной этим сканером.

String	next() - Находит и возвращает следующий полный токен из этого сканера.

String	next(Pattern pattern) - Возвращает следующий токен, если он соответствует
                                указанному шаблону.

String	next(String pattern) - Возвращает следующий токен, если он соответствует
                               шаблону, построенному из указанной строки.

BigDecimal nextBigDecimal() - Сканирует следующий токен ввода как BigDecimal.
BigInteger nextBigInteger() - Сканирует следующий токен ввода как BigInteger.
BigInteger nextBigInteger(int radix) - Сканирует следующий токен ввода как
                                       BigInteger.

boolean	nextBoolean() - Сканирует следующий токен ввода в логическое
                        значение и возвращает это значение.

byte nextByte() - Сканирует следующий токен ввода как байт.
byte nextByte(int radix) - Сканирует следующий токен ввода как байт.
double nextDouble() - Сканирует следующий токен ввода как двойной.

float nextFloat() - Сканирует следующий токен ввода как число с плавающей
                      запятой.

int	nextInt() - Сканирует следующий токен ввода как целое число.
int	nextInt(int radix) - Сканирует следующий токен ввода как целое число.

String nextLine() - Продвигает этот сканер дальше текущей строки и возвращает
                     пропущенный ввод.

long nextLong() - Сканирует следующий токен ввода как long.
long nextLong(int radix) - Сканирует следующий токен ввода как long.
short nextShort() - Сканирует следующий токен ввода как short.
short nextShort(int radix) - Сканирует следующий токен ввода как short.
int	radix() - Возвращает систему счисления по умолчанию для этого сканера.
void remove() - Операция удаления не поддерживается этой реализацией Iterator.
Scanner	reset() - Сбрасывает этот сканер.

Scanner	skip(Pattern pattern) - Пропускает ввод, соответствующий указанному шаблону,
                                игнорируя разделители.

Scanner	skip(String pattern) - Пропускает ввод, соответствующий шаблону, созданному
                               из указанной строки.

String	toString() - Возвращает строковое представление этого сканера.

Scanner	useDelimiter(Pattern pattern) - Устанавливает шаблон разграничения этого
                                        сканера на указанный шаблон.

Scanner	useDelimiter(String pattern) - Устанавливает шаблон разграничения этого сканера
                                       в шаблон, созданный из указанной строки.

Scanner	useLocale(Locale locale) - Устанавливает языковой стандарт этого сканера на
                                   указанный языковой стандарт.

Scanner	useRadix(int radix) - Устанавливает систему счисления по умолчанию для этого
                              сканера на указанную систему счисления.

-------------------------------------------------------------------------------------------
Более подробно: https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html