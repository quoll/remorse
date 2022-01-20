(ns ^{:doc "Provides function for converting strings to and from morse keywords"
      :author "Paula Gearon"}
    remorse.core
    (:require [clojure.string :as s]))

(def c->morse
  {\a ".-"
   \b "-..."
   \c "-.-."
   \d "-.."
   \e "."
   \f "..-."
   \g "--."
   \h "...."
   \i ".."
   \j ".---"
   \k "-.-"
   \l ".-.."
   \m "--"
   \n "-."
   \o "---"
   \p ".--."
   \q "--.-"
   \r ".-."
   \s "..."
   \t "-"
   \u "..-"
   \v "...-"
   \w ".--"
   \x "-..-"
   \y "-.--"
   \z "--.."
   \1 ".----"
   \2 "..---"
   \3 "...--"
   \4 "....-"
   \5 "....."
   \6 "-...."
   \7 "--..."
   \8 "---.."
   \9 "----."
   \0 "-----"
   \- "-....-"
   \+ ".-.-."
   \_ "..--.-"
   \! "..--."
   \? "..--.."
   \/ "-..-."
   \. ".-.-.-"
   \, "--..--"
   \" ".-..-."
   \' ".----."
   \: "---..."
   \; "-.-.-."
   \@ ".--.-."
   \% ".--.."
   \( "-.--."
   \) "-.--.-"
   \space ""})

(def morse->c (into {} (map (fn [[k v]] [v k]) c->morse)))

(defn string->morse
  [s]
  (->> (s/lower-case s)
       (map #(c->morse % %))
       (s/join "_")))

(defn morse->string
  [s]
  (->> (s/split s #"_")
       (map #(morse->c % %))
       (apply str)))

(defn convert
  [t f v]
  (t (namespace v) (f (name v))))

(defn keyword->morse
  [k]
  (convert keyword string->morse k))

(defn morse->keyword
  [k]
  (convert keyword morse->string k))
