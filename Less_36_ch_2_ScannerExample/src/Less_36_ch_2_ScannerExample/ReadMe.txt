Код во всех примерах реализован без защиты от дурака,
максимально примитивно, только демонстрация работы
класса Scanner и его методов - классическая напоминалка.

Less_36_ScannerPhoneBook - С клавиатуры ввести имя или телефон или команду:
                           - LIST - вывести на экран телефонный справочник;
                           - QUIT или EXIT - выйти из программы;
                           - Если вводится имя, то проверяется есть ли
                           такое в справочнике Map(k,v), и если его нет,
                           то предлагается ввести телефон.
                           - Если вводится телефон, то проверяется, есть
                           ли такой в справочнике Map(k,v) и если нет,
                           то предлагается ввести имя.

Less_36_ScannerPinCodeEnter - Имитируем ввод PIN-кода. Если он верен,
                              программа завершается, если нет, запрос
                              на ввод пароля продолжается.

Less_36_ScannerShoppingList - Пример примитивного списка продуктов.
                              Программа реализует следующие команды:
                              - ADD (index, product) - добавить продукт на нужную позицию;
                              - ADD (product) - просто добавить продукт в конец списка;
                              - EDIT (index, product) - редактировать название продукта
                                                        по индексу в списке;
                              - DELETE (index) - удалить продукт по индексу;
                              - LIST - вывести полный список продуктов;
                              - EXIT - выйти из программы.

Less_36_ScannerSplitFioString - Получить с клавиатуры строку содержащую
                                имя отчество фамилию, разделить их и
                                вывести на экран в формате:
                                - Name: Иван
                                - PatronymicName: Иванович
                                - SurName: Иванов