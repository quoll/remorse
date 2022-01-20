(ns ^{:doc "Tests for remorse.core"
      :author ".--._.-_..-_.-.._.-__--._._.-_.-._---_-."}
    remorse.core-test
    (:require [clojure.test :refer [deftest is testing]]
              [remorse.core :refer [string->morse morse->string
                                    keyword->morse morse->keyword
                                    symbol->morse morse->symbol]]))

(deftest string-to-morse
  (testing "Single characters"
    (is (= (string->morse "a") ".-"))
    (is (= (string->morse "b") "-..."))
    (is (= (string->morse "c") "-.-."))
    (is (= (string->morse "A") ".-"))
    (is (= (string->morse "B") "-..."))
    (is (= (string->morse "C") "-.-."))
    (is (= (string->morse "0") "-----"))
    (is (= (string->morse "1") ".----"))
    (is (= (string->morse "7") "--..."))
    (is (= (string->morse "$") "$"))
    (is (= (string->morse " ") "")))
  (testing "Multiple characters"
    (is (= (string->morse "abc") ".-_-..._-.-."))
    (is (= (string->morse "hello world") "...._._.-.._.-.._---__.--_---_.-._.-.._-.."))
    (is (= (string->morse "  ") "_"))
    (is (= (string->morse "hi$") "...._.._$"))
    (is (= (string->morse "he-lo") "...._._-....-_.-.._---"))))

(deftest morse-to-string
  (testing "Multiple characters"
    (is (= "a" (morse->string ".-")))
    (is (= "b" (morse->string "-...")))
    (is (= "c" (morse->string "-.-.")))
    (is (= "0" (morse->string "-----")))
    (is (= "1" (morse->string ".----")))
    (is (= "7" (morse->string "--...")))
    (is (= "" (morse->string "__")))
    (is (= "$" (morse->string "$"))))
  (testing "Multiple characters"
    (is (= "abc" (morse->string ".-_-..._-.-.")))
    (is (= "a b" (morse->string ".-__-...")))
    (is (= "hello world" (morse->string "...._._.-.._.-.._---__.--_---_.-._.-.._-..")))
    (is (= "hi!" (morse->string "...._.._!")))
    (is (= "he-lo" (morse->string "...._._-....-_.-.._---")))))

(deftest keyword-to-morse
  (testing "Simple keywords"
    (is (= :.- (keyword->morse :a)))
    (is (= :...._._.-.._.-.._--- (keyword->morse :hello)))
    (is (= :...._._-....-_.-.._--- (keyword->morse :he-lo))))
  (testing "Namespaced keywords"
    (is (= :my/.- (keyword->morse :my/a)))
    (is (= :my/...._._.-.._.-.._--- (keyword->morse :my/hello)))
    (is (= :my/...._._-....-_.-.._--- (keyword->morse :my/he-lo)))))

(deftest morse-to-keyword
  (testing "Simple keywords"
    (is (= (morse->keyword :.-) :a))
    (is (= (morse->keyword :...._._.-.._.-.._---) :hello))
    (is (= (morse->keyword :...._._-....-_.-.._---) :he-lo)))
  (testing "Namespaced keywords"
    (is (= (morse->keyword :my/.-) :my/a))
    (is (= (morse->keyword :my/...._._.-.._.-.._---) :my/hello))
    (is (= (morse->keyword :my/...._._-....-_.-.._---) :my/he-lo))))

(deftest symbol-to-morse
  (testing "Simple keywords"
    (is (= '·- (symbol->morse 'a)))
    (is (= '····_·_·-··_·-··_--- (symbol->morse 'hello)))
    (is (= '····_·_-····-_·-··_--- (symbol->morse 'he-lo))))
  (testing "Namespaced symbols"
    (is (= 'my/·- (symbol->morse 'my/a)))
    (is (= 'my/····_·_·-··_·-··_--- (symbol->morse 'my/hello)))
    (is (= 'my/····_·_-····-_·-··_--- (symbol->morse 'my/he-lo)))))

(deftest morse-to-symbol
  (testing "Simple symbols"
    (is (= (morse->symbol '·-) 'a))
    (is (= (morse->symbol '····_·_·-··_·-··_---) 'hello))
    (is (= (morse->symbol '····_·_-····-_·-··_---) 'he-lo)))
  (testing "Namespaced symbols"
    (is (= (morse->symbol 'my/·-) 'my/a))
    (is (= (morse->symbol 'my/····_·_·-··_·-··_---) 'my/hello))
    (is (= (morse->symbol 'my/····_·_-····-_·-··_---) 'my/he-lo))))
