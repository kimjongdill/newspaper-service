import React from 'react';

class Newspaper extends React.Component {

    
    constructor(props){
        super(props)
        this.latest = "http://localhost:8080/latest";
        this.random = "http://localhost:8080/random";
        this.state = {
            mode: this.latest,
            story: {},
        }

        this.randomMode = this.randomMode.bind(this);
        this.latestMode = this.latestMode.bind(this);
        
        this.loadText = (url) => { 
            fetch(url, 
                {mode: "cors",
                 method: "GET"})
                .then( response => response.json())
                .then( json => this.setState({story: json}));    
        }
    }

    randomMode = () => {
        this.loadText(this.random);
    }

    latestMode = () => {
        this.loadText(this.latest);
    }
    async componentDidMount() { 
        this.latestMode();
    }

    render() {
        return(
            <div>
                <h1>Niles Daily Star</h1>
                <button onClick={this.randomMode}>random</button>
                <button onClick={this.latestMode}>latest</button>
                <h2>{this.state.story?.title?.rendered}</h2>
                <p>{Date(this.state.story?.date)}</p>
                <div
                    dangerouslySetInnerHTML={{
                        __html: this.state.story?.content?.rendered
                    }}></div>
            </div>
        )
    }
}

export default Newspaper