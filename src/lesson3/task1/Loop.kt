

package lesson3.task1


import kotlin.math.*

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int = when {
    n == m -> 1
    n < 10 -> 0
    else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
}

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var count = 0
    var number = n
    do {
        number /= 10
        count += 1
    } while (number > 0)
    return count
}


/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n) = fib(n-1) + fib(n-2)
 */
fun fib(n: Int): Long {
    var before: Long = 1
    var after: Long = 1
    var result: Long = 0

    if (n in 1..2) return 1
    else
        for (i in 3..n) {
            result = before + after
            before = after
            after = result
        }
    return result
}


/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var result = 0
    for (i in n downTo 2)
        if (n % i == 0) result = i
    return result
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var result = 0
    for (i in 1 until n - 1)
        if (n % i == 0) result = i
    return result
}

/*fun maxDivisor(n: Int): Int {
    var result = 0
    var i = 1
    do {
        if (n % i == 0) result = i
        i++
    } while (i < n - 1)
    return result
}*/

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Хслед = X /2
 *   ИНАЧЕ
 *     Хслед = 3 * X + 1
 *
 * Например:
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */

fun collatzSteps(x: Int): Int {
    var a = x
    var counter = 0
    while (a != 1) {
        a = if (a % 2 == 0) a / 2
        else 3 * a + 1
        counter++
    }
    return counter
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */

fun lcm(m: Int, n: Int): Int {
    var result = 0
    for (i in 1..Int.MAX_VALUE) {
        if ((i % n == 0) && (i % m == 0)) {
            result = i
            break
        } else continue
    }
    return result
}


/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    val maxNumber = if (m > n) m else n
    for (i in 2 until maxNumber) {
        if ((m % i == 0) && (n % i == 0))
            return false
    }
    return true
}

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var result = 0
    var input = n
    return if (n in 1..9) n
    else {
        do {
            result = (result + (input % 10)) * 10
            input /= 10
        } while (input >= 10)
        result += input
        return result
    }
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean = n == revert(n)

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var input = n
    var before: Int
    var after = (input % 10)
    if (n in 0..9)
        return false
    while (input > 9) {
        input /= 10
        before = (input % 10)
        if (after != before) return true
        else
            after = before
    }
    return false
}


/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */

fun sin(x: Double, eps: Double): Double {
    var counter = 1
    var sin = x % (2 * Math.PI)
    val sinConst = sin
    var equation = sin
    while (abs(equation) >= eps) {
        equation = -equation * sinConst / ((counter * 2 + 1) * (counter * 2)).toDouble() * sinConst
        counter += 1
        sin += equation
    }
    return sin
}  // Решение не моё. Сделаю позже сам, когда разберусь в теме.


/*fun sin(x: Double, eps: Double): Double {
    var result = x
    var startValue
    var nextValue: Double

    for (i in 1..Int.MAX_VALUE step (2))
        nextValue = (x.pow(i) / factorial(i))


    return result
}*/

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    var equation = 1.0
    var counter = 1
    var cos = 1.0
    val constX = x % (2 * Math.PI)
    while (abs(equation) >= eps) {
        equation = -equation * constX / ((counter * 2 - 1) * (counter * 2)).toDouble() * constX
        counter += 1
        cos += equation
    }
    return cos
} // Решение не моё. Сделаю позже сам, когда разберусь в теме.

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var number: Int
    var count = 0
    var result: Int
    for (i in 1..Int.MAX_VALUE) {
        number = i * i
        result = number

        while (number > 0) {
            number /= 10
            count++
        }
        return if (count == n) result % 10
        else if (count < n) continue
        else {
            for (j in 1..(count - n)) {
                result /= 10
            }
            result % 10
        }
    }
    return 101010
}

fun main() {
    println(squareSequenceDigit(10))
}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var number: Long
    var count = 0
    var result: Long
    for (i in 1..Int.MAX_VALUE) {
        number = fib(i)
        result = number

        while (number > 0) {
            number /= 10
            count++
        }
        return if (count == n) (result % 10).toInt()
        else if (count < n) continue
        else {
            for (j in 1..(count - n)) {
                result /= 10
            }
            (result % 10).toInt()
        }
    }
    return 101010
}
