import * as React from "react";
import { Header } from './components/Header'
import { LoginTemplate } from './LoginTemplate';
import { RegisterTemplate } from './RegisterTemplate';
import Main from './Main'

const App = () => (
  <div>
    <Header />
    <LoginTemplate />
    <RegisterTemplate/>
    <Main />
  </div>
)

export default App
