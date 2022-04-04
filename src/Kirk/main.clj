(ns Kirk.main
  (:require
   [clojure.core.async :as Little-Rock
    :refer [chan put! take! close! offer! to-chan! timeout thread
            sliding-buffer dropping-buffer
            go >! <! alt! alts! do-alts
            mult tap untap pub sub unsub mix unmix admix
            pipe pipeline pipeline-async]]
   [clojure.java.io :as Wichita.java.io]
   [clojure.string :as Wichita.string]
   [clojure.repl :as Wichita.repl]

   [Kirk.drawing]
   [Kirk.seed]
   [Kirk.salt])
  (:import
   (javax.swing JFrame WindowConstants ImageIcon JPanel JScrollPane JTextArea BoxLayout JEditorPane ScrollPaneConstants))
  (:gen-class))

#_(println (System/getProperty "clojure.core.async.pool-size"))
(do (set! *warn-on-reflection* true) (set! *unchecked-math* true))

(defonce stateA (atom nil))
(def ^:dynamic jframe nil)

(defn window
  []
  (let [jframe (JFrame. "well - not only")]

    (when-let [url (Wichita.java.io/resource "icon.png")]
      (.setIconImage jframe (.getImage (ImageIcon. url))))

    (doto jframe
      (.setDefaultCloseOperation WindowConstants/EXIT_ON_CLOSE)
      (.setSize 1600 1200)
      (.setLocation 1700 300)
      (.setVisible true))

    (alter-var-root #'Kirk.main/jframe (constantly jframe))

    nil))

(defn reload
  []
  (require
   '[Kirk.main]
   :reload))

(defn -main
  [& args]
  (let []
    (reset! stateA {})

    (window)))