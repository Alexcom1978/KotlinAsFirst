package lesson4.task1

import lesson1.task1.discriminant
import kotlin.math.sqrt
import kotlin.math.pow

// Урок 4: списки
// Максимальное количество баллов = 12
// Рекомендуемое количество баллов = 8
// Вместе с предыдущими уроками = 24/33


/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) = when {
    y < 0 -> listOf()
    y == 0.0 -> listOf(0.0)
    else -> {
        val root = sqrt(y)
        // Результат!
        listOf(-root, root)
    }
}

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * Из имеющихся целых чисел, заданного через vararg-параметр, сформировать массив их квадратов
 */
fun squares(vararg array: Int) = squares(array.toList()).toTypedArray()

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.lowercase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая (2 балла)
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = if (v.isEmpty()) 0.0 else sqrt(v.sumOf { it * it })

/**
 * Простая (2 балла)
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = if (list.isEmpty()) 0.0 else list.sum() / list.size

/**
 * Средняя (3 балла)
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val a = mean(list)
    for (i in 0 until list.size) {
        val element = list[i]
        list[i] = element - a
    }
    return list
}

/*fun center(list: MutableList<Double>): MutableList<Double> {
    val a = mean(list)
    list = list.map { it - a }.toMutableList()
    return list
}*/

/*
fun main() {
    var set: MutableList<Double> = mutableListOf(1.0, 2.0, 3.0, 4.0, 5.0)
    val a = mean(set)
    println(set.map { it - a })
}
*/

/**
 * Средняя (3 балла)
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.
 *//*fun times(a: List<Int>, b: List<Int>): Int {
    var sum: List<Int>

    if (a.isEmpty() && b.isEmpty()) return 0
    else {
        sum = a.zip(b) { a, b -> a * b }  //Разобраться потом
    }
    return sum.sum()
}*/

fun times(a: List<Int>, b: List<Int>): Int {
    var result = 0
    if (a.isEmpty() && b.isEmpty()) return 0
    else {
        for (i in a.indices) {
            result += a[i] * b[i]
        }
    }
    return result
}


/**
 * Средняя (3 балла)
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0 при любом x.
 */
fun polynom(p: List<Int>, x: Int): Int {
    var result = 0.0
    if (p.isEmpty()) 0
    else {
        for (i in p.indices) result += p[i] * x.toDouble().pow(i)
    }
    return result.toInt()
}

/**
 * Средняя (3 балла)
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Int>): MutableList<Int> {
    if (list.size <= 1) return list
    else {
        var result = list[0]
        for (index in 1 until list.size) {
            result += list[index]
            list[index] = result
        }
    }
    return list
}

/**
 * Средняя (3 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
//Переписать позже. Очень медленный алгоритм!
fun factorize(n: Int): List<Int> {

    fun isSimple(n: Int): Boolean {
        for (i in 2 until n - 1) {
            if (n % i == 0) return false
        }
        return true
    }

    val result: MutableList<Int> = mutableListOf()
    var number: Int = n

    while (number > 1) {
        for (i in 2..number) {
            if ((isSimple(i)) && (number % i == 0)) {
                result.add(i)
                number /= i
                break
            }
        }
    }
    return result.sorted()
}


/**
 * Сложная (4 балла)
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 * Множители в результирующей строке должны располагаться по возрастанию.
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")


/**
 * Средняя (3 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var number: Int = n
    val result: MutableList<Int> = mutableListOf()
    if (n in 0..1) return listOf(n)
    else while (number > 0) {
        result.add(number % base)
        number /= base
    }
    return result.reversed()
}

/**
 * Сложная (4 балла)
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, n.toString(base) и подобные), запрещается.
 */
fun convertToString(n: Int, base: Int): String {
    val letters: List<String> = listOf(
        "@",
        "@",
        "@",
        "@",
        "@",
        "@",
        "@",
        "@",
        "@",
        "@",
        "a",
        "b",
        "c",
        "d",
        "e",
        "f",
        "g",
        "h",
        "i",
        "j",
        "k",
        "l",
        "m",
        "n",
        "o",
        "p",
        "q",
        "r",
        "s",
        "t",
        "u",
        "v",
        "w",
        "x",
        "y",
        "z"
    )

    var number: Int = n
    var digits: MutableList<Int> = mutableListOf()
    val result: MutableList<String> = mutableListOf()
    if (n in 0..1) return listOf(n).toString()
    else while (number > 0) {
        digits.add(number % base)
        number /= base
    }
    digits = digits.reversed().toMutableList()

    for (i in digits.indices) if (digits[i] < 9) result.add(digits[i].toString())
    else result.add(letters[digits[i]])

    return result.joinToString(separator = "")
}


/**
 * Средняя (3 балла)
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var result = 0.0
    for (i in digits.reversed().indices) {
        result += digits.reversed()[i].toDouble() * base.toDouble().pow(i)
    }
    return result.toInt()
}


/**
 * Сложная (4 балла)
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 *
 * Использовать функции стандартной библиотеки, напрямую и полностью решающие данную задачу
 * (например, str.toInt(base)), запрещается.
 */
fun decimalFromString(str: String, base: Int): Int {
    val letters: List<String> = listOf(
        "@",
        "@",
        "@",
        "@",
        "@",
        "@",
        "@",
        "@",
        "@",
        "@",
        "a",
        "b",
        "c",
        "d",
        "e",
        "f",
        "g",
        "h",
        "i",
        "j",
        "k",
        "l",
        "m",
        "n",
        "o",
        "p",
        "q",
        "r",
        "s",
        "t",
        "u",
        "v",
        "w",
        "x",
        "y",
        "z"
    )
    //Перевод из строки в лист с заменой букв на цифры.
    val chars = str.split("").filter { it != "" }.toMutableList()
    for (c in str.indices) {
        if (chars[c] in letters) chars[c] = letters.indexOf(chars[c]).toString()
    }
    // Перевод по формуле в десятичную систему
    val charsReversed = chars.reversed().map { it.toDouble() }
    val baseDouble = base.toDouble()
    var result = 0.0
    for (i in 0 until chars.size) {
        result += charsReversed[i] * baseDouble.pow(i)
    }
    return result.toInt()
}

/**
 * Сложная (5 баллов)
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    val oneToTen = listOf("0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
    val moreThen10 = listOf("0", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
    val moreThen100 = listOf("0", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
    val moreThen1000 = listOf("0", "M", "MM", "MMM", "MMMM")
    var number = n
    val result = mutableListOf<String>()

    if ((number % 10) > 0) result.add(oneToTen[number % 10])
    number /= 10
    if ((number % 10) > 0) result.add(moreThen10[number % 10])
    number /= 10
    if ((number % 10) > 0) result.add(moreThen100[number % 10])
    number /= 10
    if (number > 0) result.add(moreThen1000[number])




    return result.reversed().joinToString("")
}

/**
 * Очень сложная (7 баллов)
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val oneToTen = listOf("ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять")
    val teens = listOf(
        "", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
        "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"
    )
    val dozens = listOf(
        "", "десять", "двадцать", "тридцать", "сорок", "пятьдесят",
        "шестьдесят", "семьдесят", "восемьдесят", "девяносто"
    )
    val hundreds =
        listOf("", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")

    val thousands = listOf(
        "", "одна", "две", "три", "четыре",
        "пять", "шесть", "семь", "восемь", "девять", "десять"
    )

    var number = n
    val result = mutableListOf<String>()

    var num = ((number % 1000) / 100).toString().dropLast(2)


    if (((number % 100) == 0) && (number % 1000) / 100 in (1..9)) result.add(hundreds[(number % 1000) / 100])
    else {
        if ("0" !in num)
            when {
                ((number % 100) in (11..19)) -> {
                    result.add(teens[number % 10])
                    result.add(0, hundreds[(number % 1000) / 100])
                }

                else ->
                    when {
                        ((number % 10) == 0) -> {
                            result.add(0, dozens[(number % 100) / 10])
                            result.add(0, hundreds[(number % 1000) / 100])
                        }

                        ((number % 10) > 0) && ((number % 100) / 10 == 0) -> {
                            if (((number % 1000) / 10 != 0)) {
                                result.add(0, oneToTen[number % 10])
                                result.add(0, hundreds[(number % 1000) / 100])
                            } else result.add(0, oneToTen[number % 10])

                        }

                        else -> {
                            result.add(oneToTen[number % 10])
                            result.add(0, dozens[(number % 100) / 10])
                            result.add(0, hundreds[(number % 1000) / 100])

                        }

                    }
            }
    }
    number /= 1000

    if (number == 0) return result.joinToString(" ").trim()
    else {

        num = ((number % 1000) / 100).toString().dropLast(2)
        val resulHundreds = mutableListOf<String>()

        if (((number % 100) == 0) && (number % 1000) / 100 in (1..9))
            resulHundreds.add(hundreds[(number % 1000) / 100] + " тысяч")
        else {
            if ("0" !in num)
                when {
                    ((number % 100) in (11..19)) -> {
                        resulHundreds.add(teens[number % 10] + " тысяч")
                        resulHundreds.add(0, hundreds[(number % 1000) / 100])
                    }

                    else ->
                        when {
                            ((number % 10) == 0) -> {
                                resulHundreds.add(0, dozens[(number % 100) / 10] + " тысяч")
                                resulHundreds.add(0, hundreds[(number % 1000) / 100])
                            }

                            ((number % 10) > 0) && ((number % 100) / 10 == 0) -> {
                                if (((number % 10) in 2..4)) {
                                    resulHundreds.add(0, thousands[number % 10] + " тысячи")
                                    resulHundreds.add(0, hundreds[(number % 1000) / 100])
                                } else {
                                    resulHundreds.add(0, thousands[number % 10] + " тысяч")
                                    resulHundreds.add(0, hundreds[(number % 1000) / 100])
                                }

                            }

                            else -> {
                                if (((number % 100) / 10 in 2..4)) {
                                    resulHundreds.add(thousands[number % 10] + " тысячи")
                                    resulHundreds.add(0, dozens[(number % 100) / 10])
                                    resulHundreds.add(0, hundreds[(number % 1000) / 100])
                                } else {
                                    resulHundreds.add(thousands[number % 10] + " тысяч")
                                    resulHundreds.add(0, dozens[(number % 100) / 10])
                                    resulHundreds.add(0, hundreds[(number % 1000) / 100])
                                }

                            }

                        }
                }
        }
        result.add(0, resulHundreds.joinToString(" "))
    }

    return result.joinToString(" ").trim()
}

// Решение из интернета найденное позже
/*
val hundreds = listOf("сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
val tens = listOf("двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто")
val tens2 = listOf("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
val units = listOf("одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")
val units2 = listOf("один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять")

fun russianMiddle(middle: Int, unit: List<String>): List<String> {
    val result = mutableListOf<String>()
    if (middle / 100 >= 1) {
        val hd = middle / 100
        result.add(hundreds[hd - 1])
    }
    if (middle % 100 / 10 == 1) {
        val tn1 = middle % 10
        result.add(tens2[tn1])
    } else if (middle % 100 / 10 == 0) {
        val un = middle % 10
        if (un >= 1) result.add(unit[un - 1])
    } else {
        val tn = middle % 100 / 10
        result.add(tens[tn - 2])
        val un = middle % 10
        if (un >= 1) result.add(unit[un - 1])
    }
    return result
}

fun russian(n: Int): String {
    val result = mutableListOf<String>()
    val part1 = n / 1000
    if (part1 > 0) {
        result.addAll(russianMiddle(part1, units))
        if ((part1 % 10 == 1) && (part1 / 10 % 10 != 1)) result.add("тысяча")
        else if (!(part1 % 100 / 10 == 1) && (part1 % 10 == 2 || part1 % 10 == 3 || part1 % 10 == 4)) result.add("тысячи")
        else result.add("тысяч")
    }
    val part2 = n % 1000
    result.addAll(russianMiddle(part2, units2))
    return result.joinToString(separator = " ")
}
*/



