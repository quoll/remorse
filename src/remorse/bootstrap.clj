(ns ^{:doc "Sets up initial bootstrap macros for subsequent code."
      :author "Paula Gearon"}
    remorse.bootstrap)

(defmacro -··_·_··-·_--_·-_-·-·_·-·_--- [& _··-·_---_·-·_--_···] `(defmacro ~@_··-·_---_·-·_--_···))

(-··_·_··-·_--_·-_-·-·_·-·_--- -··_·_··-· [_··· _···-] `(def ~_··· ~_···-))
(-··_·_··-·_--_·-_-·-·_·-·_--- _··-·_-· [& _···_··_--·_···] `(fn ~@_···_··_--·_···))
(-··_·_··-·_--_·-_-·-·_·-·_--- _·-··_·_- [& -···_-·_-··_·-·-·_··-·_---_·-·_--_···]
                               `(let ~@-···_-·_-··_·-·-·_··-·_---_·-·_--_···))
(-··_·_··-·_--_·-_-·-·_·-·_--- -··_·_··-·_-· [& ···_··_--·_···] `(defn ~@···_··_--·_···))
(-··_·_··-·_--_·-_-·-·_·-·_--- _··_··-· [& -] `(if ~@-))
