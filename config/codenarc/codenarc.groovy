ruleset {
    description '''
        OFBiz ruleset adapted from basic one from https://codenarc.org/StarterRuleSet-AllRulesByCategory.groovy.txt
        Each rule is commented and priority qualified.
        '''

    // rulesets/basic.xml
    AssertWithinFinallyBlock // Checks for assert statements within a finally block. An assert can throw an exception, hiding the original exception, if there is one.
    AssignmentInConditional // p2 : An assignment operator (=) was used in a conditional test. This is usually a typo, and the comparison operator (==) was intended.
    BigDecimalInstantiation // Checks for calls to the BigDecimal constructors that take a double parameter, which may result in an unexpected BigDecimal value.
    BitwiseOperatorInConditional // Checks for bitwise operations in conditionals, if you need to do a bitwise operation then it is best practice to extract a temp variable.
    BooleanGetBoolean // This rule catches usages of java.lang.Boolean.getBoolean(String) which reads a boolean from the System properties. It is often mistakenly used to attempt to read user input or parse a String into a boolean. It is a poor piece of API to use; replace it with System.properties['prop'].
    BrokenNullCheck // Looks for faulty checks for null that can cause a NullPointerException.
    BrokenOddnessCheck // The code uses x % 2 == 1 to check to see if a value is odd, but this won't work for negative numbers (e.g., (-5) % 2 == -1). If this code is intending to check for oddness, consider using x & 1 == 1, or x % 2 != 0.
    ClassForName // Using Class.forName(...) is a common way to add dynamic behavior to a system. However, using this method can cause resource leaks because the classes can be pinned in memory for long periods of time.
    ComparisonOfTwoConstants // Checks for expressions where a comparison operator or equals() or compareTo() is used to compare two constants to each other or two literals that contain only constant values.
    ComparisonWithSelf // Checks for expressions where a comparison operator or equals() or compareTo() is used to compare a variable to itself, e.g.: x == x, x != x, x <=> x, x < x, x =>= x, x.equals(x) or x.compareTo(x), where x is a variable.
    ConstantAssertExpression // Checks for assert statements where the assert boolean condition expression is a constant or literal value.
    ConstantIfExpression // Checks for if statements with a constant value for the if expression, such as true, false, null, or a literal constant value.
    ConstantTernaryExpression // Checks for ternary expressions with a constant value for the boolean expression, such as true, false, null, or a literal constant value.
    DeadCode // Dead code appears after a return statement or an exception is thrown. If code appears after one of these statements then it will never be executed and can be safely deleted.
    DoubleNegative // There is no point in using a double negative, it is always positive. For instance !!x can always be simplified to x. And !(!x) can as well.
    DuplicateCaseStatement // Check for duplicate case statements in a switch block, such as two equal integers or strings.
    DuplicateMapKey // A map literal is created with duplicated key. The map entry will be overwritten.
    DuplicateSetValue // A Set literal is created with duplicate constant value. A set cannot contain two elements with the same value.
    EmptyCatchBlock // In most cases, exceptions should not be caught and ignored (swallowed).
    EmptyClass // Reports classes without methods, fields or properties. Why would you need a class like this?
    EmptyElseBlock // Empty else blocks are confusing and serve no purpose.
    EmptyFinallyBlock // Empty finally blocks are confusing and serve no purpose.
    EmptyForStatement // Empty for statements are confusing and serve no purpose.
    EmptyIfStatement // Empty if statements are confusing and serve no purpose.
    EmptyInstanceInitializer // An empty class instance initializer was found. It is safe to remove it.
    EmptyMethod // A method was found without an implementation. If the method is overriding or implementing a parent method, then mark it with the @Override annotation.
    EmptyStaticInitializer // An empty static initializer was found. It is safe to remove it.
    EmptySwitchStatement // Empty switch statements are confusing and serve no purpose.
    EmptySynchronizedStatement // Empty synchronized statements are confusing and serve no purpose.
    EmptyTryBlock // Empty try blocks are confusing and serve no purpose.
    EmptyWhileStatement // Empty while statements are confusing and serve no purpose.
    EqualsAndHashCode // If either the boolean equals(Object) or the int hashCode() methods are overridden within a class, then both must be overridden.
    EqualsOverloaded // The class has an equals method, but the parameter of the method is not of type Object. It is not overriding equals but instead overloading it.
    ExplicitGarbageCollection // Calls to System.gc(), Runtime.getRuntime().gc(), and System.runFinalization() are not advised. Code should have the same behavior whether the garbage collection is disabled using the option -Xdisableexplicitgc or not. Moreover, "modern" jvms do a very good job handling garbage collections. If memory usage issues unrelated to memory leaks develop within an application, it should be dealt with JVM options rather than within the code itself.
    ForLoopShouldBeWhileLoop // A for loop without an init and update statement can be simplified to a while loop.
    HardCodedWindowsFileSeparator // This rule finds usages of a Windows file separator within the constructor call of a File object. It is better to use the Unix file separator or use the File.separator constant.
    HardCodedWindowsRootDirectory // This rule find cases where a File object is constructed with a windows-based path. This is not portable, and using the File.listRoots() method is a better alternative.
    IntegerGetInteger // This rule catches usages of java.lang.Integer.getInteger(String, ...) which reads an Integer from the System properties. It is often mistakenly used to attempt to read user input or parse a String into an Integer. It is a poor piece of API to use; replace it with System.properties['prop'].
    MultipleUnaryOperators // Checks for multiple consecutive unary operators. These are confusing, and are likely typos and bugs.
    RandomDoubleCoercedToZero // The Math.random() method returns a double result greater than or equal to 0.0 and less than 1.0. If you coerce this result into an Integer or int, then it is coerced to zero. Casting the result to int, or assigning it to an int field is probably a bug.
    RemoveAllOnSelf // Don't use removeAll to clear a collection. If you want to remove all elements from a collection c, use c.clear, not c.removeAll(c). Calling c.removeAll(c) to clear a collection is less clear, susceptible to errors from typos, less efficient and for some collections, might throw a ConcurrentModificationException.
    ReturnFromFinallyBlock // Returning from a finally block is confusing and can hide the original exception.
    ThrowExceptionFromFinallyBlock // Throwing an exception from a finally block is confusing and can hide the original exception.

    // rulesets/braces.xml
    ElseBlockBraces // Use braces for else blocks, even for a single statement. By default, braces are not required for an else if it is followed immediately by an if. Set the bracesRequiredForElseIf property to true to require braces is that situation as well.
    ForStatementBraces // Use braces for for statements, even for a single statement.
    IfStatementBraces
    WhileStatementBraces

    // rulesets/comments.xml
    ClassJavadoc
    JavadocConsecutiveEmptyLines
    JavadocEmptyAuthorTag
    JavadocEmptyExceptionTag
    JavadocEmptyFirstLine
    JavadocEmptyLastLine
    JavadocEmptyParamTag
    JavadocEmptyReturnTag
    JavadocEmptySeeTag
    JavadocEmptySinceTag
    JavadocEmptyThrowsTag
    JavadocEmptyVersionTag
    JavadocMissingExceptionDescription
    JavadocMissingParamDescription
    JavadocMissingThrowsDescription

    // rulesets/concurrency.xml
    BusyWait
    DoubleCheckedLocking
    InconsistentPropertyLocking
    InconsistentPropertySynchronization
    NestedSynchronization
    StaticCalendarField
    StaticConnection
    StaticDateFormatField
    StaticMatcherField
    StaticSimpleDateFormatField
    SynchronizedMethod
    SynchronizedOnBoxedPrimitive
    SynchronizedOnGetClass
    SynchronizedOnReentrantLock
    SynchronizedOnString
    SynchronizedOnThis
    SynchronizedReadObjectMethod
    SystemRunFinalizersOnExit
    ThisReferenceEscapesConstructor
    ThreadGroup
    ThreadLocalNotStaticFinal
    ThreadYield
    UseOfNotifyMethod
    VolatileArrayField
    VolatileLongOrDoubleField
    WaitOutsideOfWhileLoop

    // rulesets/convention.xml
    //CompileStatic
    ConfusingTernary
    CouldBeElvis
    CouldBeSwitchStatement
    FieldTypeRequired
    HashtableIsObsolete
    IfStatementCouldBeTernary
    ImplicitClosureParameter
    InvertedCondition
    InvertedIfElse
    LongLiteralWithLowerCaseL
    MethodParameterTypeRequired
    MethodReturnTypeRequired
    NoDef
    NoDouble
    NoFloat
    NoJavaUtilDate
    NoTabCharacter
    ParameterReassignment
    PublicMethodsBeforeNonPublicMethods
    StaticFieldsBeforeInstanceFields
    StaticMethodsBeforeInstanceMethods
    TernaryCouldBeElvis
    VariableTypeRequired
    VectorIsObsolete

    // rulesets/design.xml
    AbstractClassWithPublicConstructor
    AbstractClassWithoutAbstractMethod
    AssignmentToStaticFieldFromInstanceMethod
    BooleanMethodReturnsNull
    BuilderMethodWithSideEffects
    CloneableWithoutClone
    CloseWithoutCloseable
    CompareToWithoutComparable
    ConstantsOnlyInterface
    EmptyMethodInAbstractClass
    FinalClassWithProtectedMember
    ImplementationAsType
    Instanceof
    LocaleSetDefault
    NestedForLoop
    PrivateFieldCouldBeFinal
    PublicInstanceField
    ReturnsNullInsteadOfEmptyArray
    ReturnsNullInsteadOfEmptyCollection
    SimpleDateFormatMissingLocale
    StatelessSingleton
    ToStringReturnsNull

    // rulesets/dry.xml
    DuplicateListLiteral
    DuplicateMapLiteral

    // rulesets/enhanced.xml
    CloneWithoutCloneable
    JUnitAssertEqualsConstantActualValue
    MissingOverrideAnnotation
    UnsafeImplementationAsMap

    // rulesets/exceptions.xml
    CatchArrayIndexOutOfBoundsException
    CatchError
    CatchException
    CatchIllegalMonitorStateException
    CatchIndexOutOfBoundsException
    CatchNullPointerException
    CatchRuntimeException
    CatchThrowable
    ConfusingClassNamedException
    ExceptionExtendsError
    ExceptionExtendsThrowable
    ExceptionNotThrown
    MissingNewInThrowStatement
    ReturnNullFromCatchBlock
    SwallowThreadDeath
    ThrowError
    ThrowException
    ThrowNullPointerException
    ThrowRuntimeException
    ThrowThrowable

    // rulesets/formatting.xml
    BlankLineBeforePackage
    BlockEndsWithBlankLine
    BlockStartsWithBlankLine
    BracesForClass
    BracesForForLoop
    BracesForIfElse
    BracesForMethod
    BracesForTryCatchFinally
    ClassEndsWithBlankLine
    ClassStartsWithBlankLine
    ClosureStatementOnOpeningLineOfMultipleLineClosure
    ConsecutiveBlankLines
    FileEndsWithoutNewline
    Indentation
    LineLength(length: 150)
    MissingBlankLineAfterImports
    MissingBlankLineAfterPackage
    SpaceAfterCatch
    SpaceAfterClosingBrace
    SpaceAfterComma
    SpaceAfterFor
    SpaceAfterIf
    SpaceAfterOpeningBrace
    SpaceAfterSemicolon
    SpaceAfterSwitch
    SpaceAfterWhile
    SpaceAroundClosureArrow
    SpaceAroundMapEntryColon(characterAfterColonRegex: /\s/)
    SpaceAroundOperator
    SpaceBeforeClosingBrace
    SpaceBeforeOpeningBrace
    TrailingWhitespace

    // rulesets/generic.xml
    IllegalClassMember
    IllegalClassReference
    IllegalPackageReference
    IllegalRegex
    IllegalString
    IllegalSubclass
    RequiredRegex
    RequiredString
    StatelessClass

    // rulesets/grails.xml
    GrailsDomainHasEquals
    GrailsDomainHasToString
    GrailsDomainReservedSqlKeywordName
    GrailsDomainStringPropertyMaxSize
    GrailsDomainWithServiceReference
    GrailsDuplicateConstraint
    GrailsDuplicateMapping
    GrailsMassAssignment
    GrailsPublicControllerMethod
    GrailsServletContextReference
    GrailsStatelessService

    // rulesets/groovyism.xml
    AssignCollectionSort
    AssignCollectionUnique
    ClosureAsLastMethodParameter
    CollectAllIsDeprecated
    ConfusingMultipleReturns
    ExplicitArrayListInstantiation
    ExplicitCallToAndMethod
    ExplicitCallToCompareToMethod
    ExplicitCallToDivMethod
    ExplicitCallToEqualsMethod
    ExplicitCallToGetAtMethod
    ExplicitCallToLeftShiftMethod
    ExplicitCallToMinusMethod
    ExplicitCallToModMethod
    ExplicitCallToMultiplyMethod
    ExplicitCallToOrMethod
    ExplicitCallToPlusMethod
    ExplicitCallToPowerMethod
    ExplicitCallToPutAtMethod
    ExplicitCallToRightShiftMethod
    ExplicitCallToXorMethod
    ExplicitHashMapInstantiation
    ExplicitHashSetInstantiation
    ExplicitLinkedHashMapInstantiation
    ExplicitLinkedListInstantiation
    ExplicitStackInstantiation
    ExplicitTreeSetInstantiation
    GStringAsMapKey
    GStringExpressionWithinString
    GetterMethodCouldBeProperty
    GroovyLangImmutable
    UseCollectMany
    UseCollectNested

    // rulesets/imports.xml
    DuplicateImport
    ImportFromSamePackage
    ImportFromSunPackages
    MisorderedStaticImports
    NoWildcardImports
    UnnecessaryGroovyImport
    UnusedImport

    // rulesets/jdbc.xml
    DirectConnectionManagement
    JdbcConnectionReference
    JdbcResultSetReference
    JdbcStatementReference

    // rulesets/junit.xml
    ChainedTest
    CoupledTestCase
    JUnitAssertAlwaysFails
    JUnitAssertAlwaysSucceeds
    JUnitFailWithoutMessage
    JUnitLostTest
    JUnitPublicField
    JUnitPublicNonTestMethod
    JUnitPublicProperty
    JUnitSetUpCallsSuper
    JUnitStyleAssertions
    JUnitTearDownCallsSuper
    JUnitTestMethodWithoutAssert
    JUnitUnnecessarySetUp
    JUnitUnnecessaryTearDown
    JUnitUnnecessaryThrowsException
    SpockIgnoreRestUsed
    UnnecessaryFail
    UseAssertEqualsInsteadOfAssertTrue
    UseAssertFalseInsteadOfNegation
    UseAssertNullInsteadOfAssertEquals
    UseAssertSameInsteadOfAssertTrue
    UseAssertTrueInsteadOfAssertEquals
    UseAssertTrueInsteadOfNegation

    // rulesets/logging.xml
    LoggerForDifferentClass
    LoggerWithWrongModifiers
    LoggingSwallowsStacktrace
    MultipleLoggers
    PrintStackTrace
    Println
    SystemErrPrint
    SystemOutPrint

    // rulesets/naming.xml
    AbstractClassName
    ClassName
    ClassNameSameAsFilename
    ClassNameSameAsSuperclass
    ConfusingMethodName
    FieldName
    InterfaceName
    InterfaceNameSameAsSuperInterface
    MethodName
    ObjectOverrideMisspelledMethodName
    PackageName
    PackageNameMatchesFilePath
    ParameterName
    PropertyName
    VariableName

    // rulesets/security.xml
    FileCreateTempFile
    InsecureRandom
    JavaIoPackageAccess
    NonFinalPublicField
    NonFinalSubclassOfSensitiveInterface
    ObjectFinalize
    PublicFinalizeMethod
    SystemExit
    UnsafeArrayDeclaration

    // rulesets/serialization.xml
    EnumCustomSerializationIgnored
    SerialPersistentFields
    SerialVersionUID
    SerializableClassMustDefineSerialVersionUID

    // rulesets/size.xml
    // TODO : need refactoring AbcMetric   // Requires the GMetrics jar
    ClassSize
    CrapMetric   // Requires the GMetrics jar and a Cobertura coverage file
    CyclomaticComplexity   // Requires the GMetrics jar
    MethodCount
    MethodSize
    // TODO : need serious refactoring NestedBlockDepth
    ParameterCount

    // rulesets/unnecessary.xml
    AddEmptyString
    ConsecutiveLiteralAppends
    ConsecutiveStringConcatenation
    UnnecessaryBigDecimalInstantiation
    UnnecessaryBigIntegerInstantiation
    UnnecessaryBooleanExpression
    UnnecessaryBooleanInstantiation
    UnnecessaryCallForLastElement
    UnnecessaryCallToSubstring
    UnnecessaryCast
    UnnecessaryCatchBlock
    UnnecessaryCollectCall
    UnnecessaryCollectionCall
    UnnecessaryConstructor
    UnnecessaryDefInFieldDeclaration
    UnnecessaryDefInMethodDeclaration
    UnnecessaryDefInVariableDeclaration
    UnnecessaryDotClass
    UnnecessaryDoubleInstantiation
    UnnecessaryElseStatement
    UnnecessaryFinalOnPrivateMethod
    UnnecessaryFloatInstantiation
    UnnecessaryGString
    //UnnecessaryGetter
    UnnecessaryIfStatement
    UnnecessaryInstanceOfCheck
    UnnecessaryInstantiationToGetClass
    UnnecessaryIntegerInstantiation
    UnnecessaryLongInstantiation
    UnnecessaryModOne
    UnnecessaryNullCheck
    UnnecessaryNullCheckBeforeInstanceOf
    UnnecessaryObjectReferences(maxReferencesAllowed: 8)
    UnnecessaryOverridingMethod
    UnnecessaryPackageReference
    UnnecessaryParenthesesForMethodCallWithClosure
    UnnecessaryPublicModifier
    //UnnecessaryReturnKeyword
    UnnecessarySafeNavigationOperator
    UnnecessarySelfAssignment
    UnnecessarySemicolon
    //UnnecessarySetter
    UnnecessaryStringInstantiation
    UnnecessaryTernaryExpression
    UnnecessaryToString
    UnnecessaryTransientModifier

    // rulesets/unused.xml
    UnusedArray
    UnusedMethodParameter
    UnusedObject
    UnusedPrivateField
    UnusedPrivateMethod
    UnusedPrivateMethodParameter
    UnusedVariable
}
