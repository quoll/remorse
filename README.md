# remorse
Clojure and ClojureScript to morse code conversion

## Usage

### Dependencies
This can be included in `deps.edn` with the following entry in the `:deps` map:

```clojure
com.github.quoll/remorse {:git/tag "0.2.0" :git/sha "5c58cfb"}
```

### Keywords
Keywords can be converted to and from morse code.

```clojure
=> (require '[remorse.core :as rm])
nil

=> (rm/keyword->morse :hello)
:...._._.-.._.-.._---

=> (rm/keyword->morse :my/hello-world)
:my/...._._.-.._.-.._---_-....-_.--_---_.-._.-.._-..

=> (rm/morse->keyword :...._._.-.._.-.._---)
:hello

=> (rm/morse->keyword :my/...._._.-.._.-.._---_-....-_.--_---_.-._.-.._-..)
:my/hello-world
```

### Strings
Strings can also be converted. Leading and trailing spaces will be dropped.

```clojure
=> (rm/morse->string "...._._.-.._.-.._---")
"hello"

=> (rm/string->morse "hello world")
"...._._.-.._.-.._---__.--_---_.-._.-.._-.."

=> (rm/morse->string "...._._.-.._.-.._---__.--_---_.-._.-.._-..")
"hello world"
```

### Symbols
Symbols can be converted to morse, but they are unable to use the `.` character. Instead, they use Unicode character 0x00b7: `·`

```clojure
=> (rm/symbol->morse 'hello)
_····_·_·-··_·-··_---

=> (rm/morse->symbol '_····_·_·-··_·-··_---)
hello
```
Note that JavaScript (and hence ClojureScript) cannot accept a symbol that starts with `·` so any symbols that start this way will be prepended with a separator character (an underscore).

## Development
This project dogfoods itself. You probably don't want to look at the code.

# License
Copyright © 2022 Paula Gearon
Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
