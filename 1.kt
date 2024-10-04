import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

data class Expense(
    val amount: Double, val category: String, val date: LocalDate
) {
    override fun toString(): String {
        return "Spent $$amount on $category at $date"
    }
}


class Expenses {
    private val expenses: ArrayList<Expense> = arrayListOf()

    fun addExpense(expense: Expense) {
        expenses.add(expense)
    }

    fun getExpenses(): List<Expense> {
        return expenses
    }

    fun printExpenses() {
        println("Expenses: ")
        val sortedExpenses = expenses.sortedBy { it.date }

        for (expense in sortedExpenses) {
            println(expense)
        }
    }

    fun printTotals(category: String) {
        val sum = expenses.filter { it.category == category }.sumOf { it.amount }
        println("$category: $$sum")
    }

    fun printAllTotals() {
        val categories = expenses.map { it.category }.distinct()

        println("Totals: ")
        for (category in categories) {
            printTotals(category)
        }
    }
}
sealed class Test

fun showAddExpensePrompt() {
    print("Category: ")
    val category = scanner.next()
    print("Amount: ")
    val amount = scanner.nextDouble()
    print("Date(yyyy-MM-dd): ")
    val dateString = scanner.next()
    val date = LocalDate.parse(dateString)

    val expense = Expense(
        amount, category, date
    )
    expenses.addExpense(expense)
}


val expenses = Expenses()
val scanner = Scanner(System.`in`)

val res: (Int, Int) -> Int = fun(a: Int, b: Int): Int {
    return a * b
}

val res: (Int)

fun main() {
    while (true) {
        println(
            "Menu:\n" + "1. Add expense\n" + "2. List expenses\n" + "3. Print totals\n" + "0. Exit"
        )

        print(">> ")
        val choice = scanner.next()

        println(res(3, 4))

        when (choice.trim()) {
            "0" -> {
                break
            }
            "1" -> {
                try {
                    showAddExpensePrompt()
                } catch (e: Exception) {
                    println("Invalid input")
                }
            }

            "2" -> {
                expenses.printExpenses()
            }

            "3" -> {
                expenses.printAllTotals()
            }

            else -> {
                println("Invalid option")
            }
        }
        println()
    }
}
