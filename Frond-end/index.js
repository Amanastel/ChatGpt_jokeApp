document.getElementById('generateButton').addEventListener('click', async () => {
    const userInput = document.getElementById('userInput').value;
  
    try {
      const response = await fetch(`http://localhost:8080/chat?prompt=${userInput}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ userInput })
      });
      
      const data = await response.json();
      console.log(data);
      displayShayari(data.content);
    } catch (error) {
      console.error('Error generating Shayari:', error.message);
    }
  });
  
  function displayShayari(shayari) {
    const shayariDisplay = document.getElementById('shayariDisplay');
    shayariDisplay.innerText = shayari;
    shayariDisplay.style.display = 'block';
  }
  