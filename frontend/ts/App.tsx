import * as React from "react";
import { Header } from './components/Header'
import { LoginComponent } from './components/LoginComponent';
import { RegisterComponent } from './components/RegisterComponent';
import Main from './Main'

const App = () => (
  <div>
    <Header />
    <LoginComponent />
    <RegisterComponent/>
    <Main />
  </div>
)

export default App
