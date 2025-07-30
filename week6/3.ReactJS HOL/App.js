import { CalculateScore } from '../src/Components/CalculateScore';
function App() {
  return(
    <div>
      <CalculateScore Name={"Steeve"}
        School={"ABC High School"}
        total={450}
        goal={500}
      />
    </div>
  )
}
export default App;