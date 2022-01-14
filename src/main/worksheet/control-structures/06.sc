def assertTrue(predicate: () => Boolean): Boolean = predicate()

assertTrue(() => 12 > 10)
assertTrue(() => 12 + 34 - 12 > 30)

/** result in compilation failure,
 *  since it needs a function that takes,
 *  nothing and returns Boolean
 */

// assertTrue(12 > 10)
