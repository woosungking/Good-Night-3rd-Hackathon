import React from 'react';
import post from '../../assets/post2.png';

const CommentPostIt: React.FC = ({ content }) => {
  return (
    <div className="relative">
      <img src={post} className="w-[300px] h-[300px]" />
      <p className="absolute bottom-[17%] left-[10%] w-[200px] h-[200px] break-words">
        {content}
      </p>
    </div>
  );
};
export default CommentPostIt;
