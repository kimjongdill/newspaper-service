import React from 'react';

class Newspaper extends React.Component {
    
    constructor(props){
        super(props)
        this.url = props.url;
        
        this.state = {
            mode: this.latest,
            story: {},
        }

        this.loadText = () => {
            fetch(this.url,
                {mode: "cors",
                 method: "GET"})
                .then( response => response.json())
                .then( json => this.setState({story: json}));
        }
    }

    async componentDidMount() {
        this.loadText();
    }

    render() {
        const dateOptions = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
        let date = new Date(this.state.story?.date);

        return(
            <div className="frontPage">
                <div className="stripe">
                    <div className="date">
                        {date.toLocaleDateString("en-US", dateOptions) + "\t\t"}
                    </div>
                    SERVING NILES, BUCHANAN, AND EDWARDSBURG
                </div>
                <div className="banner">
                    Niles Daily Star
                </div>
                <div className="buttons">&nbsp;</div>
                <div className="headline">
                    <h2>{this.state.story?.title?.rendered}</h2>
                </div>
                <div className="story">
                    {this.state.story?.jetpack_featured_media_url ?
                        <img class="picture" src={this.state.story?.jetpack_featured_media_url}></img>
                        : ""
                    }
                    <div className="byline">
                        <p><b>By CHRISTINA CLARK</b></p>
                        <p>christina.clark@leaderpub.com</p>
                    </div>
                    <div dangerouslySetInnerHTML={{
                            __html: this.state.story?.content?.rendered
                        }}></div>

                </div>
            </div>
        )
    }
}

export default Newspaper