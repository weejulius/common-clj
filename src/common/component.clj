(ns common.component)

(defprotocol Lifecycle
  "manage the lifecycle of component, options is used to pass
   params to component"
  (init [this options] "init the component")
  (start [this options] "start the component or restart the stopped component")
  (stop [this options] "stop the started component")
  (halt [this options] "shutdown the component when it is to be down"))

