(ns ^{:doc "Provides function for converting strings to and from morse keywords"
      :author ".--._.-_..-_.-.._.-__--._._.-_.-._---_-."}
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

(let [[mc cd dc] (reduce (fn [[m c d] [k v]]
                           (let [dv (s/replace v \. \u00b7)]
                             [(conj m [v k]) (conj c [k dv]) (conj d [dv k])]))
                         [{} {} {}] c->morse)]
  (def morse->c mc)
  (def c->dmorse cd)
  (def dmorse->c dc))

(defn string->morse
  ([s] (string->morse c->morse s))
  ([m s]
   (->> (s/lower-case s)
        (map #(m % %))
        (s/join "_"))))

(defn morse->string
  ([s] (morse->string morse->c s))
  ([m s]
   (->> (s/split s #"_")
        (map #(m % %))
        (apply str))))

(defn convert
  [t f v]
  (t (namespace v) (f (name v))))

(defn keyword->morse
  [k]
  (convert keyword string->morse k))

(defn morse->keyword
  [k]
  (convert keyword morse->string k))

(defn symbol->morse
  [s]
  (convert symbol #(string->morse c->dmorse %) s))

(defn morse->symbol
  [s]
  (convert symbol #(morse->string dmorse->c %) s))
