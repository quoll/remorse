# remorse
Keyword to morse code conversion

## Usage

### Dependencies
This can be included in `deps.edn` with the following entry in the `:deps` map:

```clojure
com.github.quoll/remorse {:git/tag "0.0.2" :git/sha "4ff7d73"}
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

# License
Copyright © 2022 Paula Gearon
Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.
